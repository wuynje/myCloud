package com.tianhai.redis.lock;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @Author: wuynje
 * @Date: 2021/9/5 12:06
 * @Description: Jedis实现，官方建议使用Redisson来实现
 */
public class RedisLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    //正确加锁做法
    public static boolean lock() {
        Jedis jedis = new Jedis();
        String result = jedis.set("lockKey", "value", SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 1000L);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    //错误加锁加锁做，如果过期时间在设置的时候系统崩溃，那么死锁
    public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {

        Long result = jedis.setnx(lockKey, requestId);
        if (result == 1) {
            // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
            jedis.expire(lockKey, expireTime);
        }

    }

    //错误加锁，这种方法需要同步每台机器的时间。
    public static boolean wrongGetLock2(Jedis jedis, String lockKey, int expireTime) {

        long expires = System.currentTimeMillis() + expireTime;
        String expiresStr = String.valueOf(expires);

        // 如果当前锁不存在，返回加锁成功
        if (jedis.setnx(lockKey, expiresStr) == 1) {
            return true;
        }

        // 如果锁存在，获取锁的过期时间
        String currentValueStr = jedis.get(lockKey);
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
            // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间
            String oldValueStr = jedis.getSet(lockKey, expiresStr);
            if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才有权利加锁
                return true;
            }
        }
        // 其他情况，一律返回加锁失败
        return false;
    }

    //解锁

    /**
     * 释放分布式锁
     * 通过LUA脚本操作实现原子性
     *
     * @param jedis     Redis客户端
     * @param lockKey   锁
     * @param requestId 请求标识,value
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    //不正确，不判断requestID解锁的话，实现不了可重入锁
    public static void wrongReleaseLock1(Jedis jedis, String lockKey) {
        jedis.del(lockKey);
    }

    //不正确，非原子性，如果判断的时候别人自己解锁了，别人加锁，就解锁错了，就是因为判断的这一步不是原子性
    public static void wrongReleaseLock2(Jedis jedis, String lockKey, String requestId) {

        // 判断加锁与解锁是不是同一个客户端
        if (requestId.equals(jedis.get(lockKey))) {
            // 若在此时，这把锁突然不是这个客户端的，则会误解锁
            jedis.del(lockKey);
        }

    }


}

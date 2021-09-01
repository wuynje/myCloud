package com.tianhai.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: wuynje
 * @Date: 2021/7/7 17:18
 * @Description:倒计时器（属于闭锁的一种实现），用来阻塞线程
 * 使用方法，CountDownLatch创建时需要给一个count
 * 调用await()方法使如果count不为0，则线程阻塞，
 * 调用countDown()方法使count减一，到0停止阻塞
 * 可以实现类似join()方法的作用
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void test(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName()+">>>>>>>>");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"我是线程一").start();
        Thread.sleep(5000);
        System.out.println("5s等待结束，开始执行");
        countDownLatch.countDown();
    }

}

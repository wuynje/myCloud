package com.tianhai.redis.mq;

/**
 * @Author: wuynje
 * @Date: 2021/9/5 16:41
 * @Description:Redis作消息队列使用
 */
public class RedisMQ {

int value;
    public int getValue() {
        try {
            value ++;
            return value;
        } finally {
//            this.setValue(value);
            System.out.println(value);
        }
    }
}

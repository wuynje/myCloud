package com.tianhai.designMode.observer;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 14:53
 * @Description: 观察者模式（监听实现原理）
 *
 * 具体的观察者，对被订阅的话题（即被观察的对象）做出业务操作
 *
 */
public interface Ovserver {

    /**
     *
     * 被通知后根据具体的话题做出的具体业务操作
     * @param msg
     */
    public void doSomeThing(String msg);

}

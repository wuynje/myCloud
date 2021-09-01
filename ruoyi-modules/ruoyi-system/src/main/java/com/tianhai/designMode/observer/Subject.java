package com.tianhai.designMode.observer;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 14:51
 * @Description: 观察者模式（监听实现原理）
 *
 * 课题需要实现的接口
 */
public interface Subject {

    /**
     * 订阅
     * @param ovserver
     */
    public void subscribe(Ovserver ovserver);

    /**
     * 取消订阅
     * @param ovserver
     */
    public void cancelSubscribe(Ovserver ovserver);


    /**
     * 通知订阅者，订阅者被通知后做出相应的反应
     * @param msg
     */
    public void notifyOvserver(String msg);

}

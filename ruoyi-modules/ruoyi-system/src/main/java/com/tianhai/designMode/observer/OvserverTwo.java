package com.tianhai.designMode.observer;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 15:23
 * @Description:观察者一
 */
public class OvserverTwo implements Ovserver {
    @Override
    public void doSomeThing(String msg) {
        System.out.println("OvserverTwo监听到"+msg);
    }
}

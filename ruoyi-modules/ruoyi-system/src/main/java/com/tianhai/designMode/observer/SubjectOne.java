package com.tianhai.designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 15:13
 * @Description:话题类型一
 */
public class SubjectOne implements Subject {

    /**
     * 订阅者列表
     */
    protected List<Ovserver> ovserverList = new ArrayList<Ovserver>();

    /**
     * 订阅
     * @param ovserver
     */
    @Override
    public void subscribe(Ovserver ovserver){
        this.ovserverList.add(ovserver);
    }

    /**
     * 取消订阅
     * @param ovserver
     */
    @Override
    public void cancelSubscribe(Ovserver ovserver){
        this.ovserverList.remove(ovserver);
    }

    /**
     * 通知订阅者，订阅者被通知后做出相应的反应
     */
    @Override
    public void notifyOvserver(String msg){
        for(Ovserver ovserver : ovserverList){
            ovserver.doSomeThing(msg);
        }
    }
}

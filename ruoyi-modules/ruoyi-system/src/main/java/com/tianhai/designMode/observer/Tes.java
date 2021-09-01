package com.tianhai.designMode.observer;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 15:34
 * @Description:
 *
 * 观察者模式，
 * 一：定义一个subject接口，该接口定义添加观察者，移除观察者，通知观察者三个方法
 * 二：定义一个观察者接口，该接口定义具体的业务操作方法用来响应subject通知后的处理逻辑
 * 三：定义一个subject接口的实现类，该实现类需要定一个观察者List的成员变量，实现具体的添加观察者，移除观察者，通知观察者方法
 * 四：定义一个Ovserver接口的实现类，该类实现具体的业务操作方法
 * 五：完事、测试
 */
public class Tes {

    public static void test(String[] args) {
        //课题
        Subject subjectOne = new SubjectOne();
        Ovserver ovserverOne = new OvserverOne();
        Ovserver ovserverTwo = new OvserverTwo();
        subjectOne.subscribe(ovserverOne);
        subjectOne.subscribe(ovserverTwo);
        subjectOne.notifyOvserver("第一个消息。。。");


        //ovserverTwo取消了订阅
        subjectOne.cancelSubscribe(ovserverTwo);
        subjectOne.notifyOvserver("第二个消息。。。");

    }

}

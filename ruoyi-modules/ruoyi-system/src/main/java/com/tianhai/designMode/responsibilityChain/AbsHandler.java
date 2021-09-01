package com.tianhai.designMode.responsibilityChain;

/**
 * @Author: wuynje
 * @Date: 2021/7/19 17:05
 * @Description: 责任链模式
 *
 * 定义一个抽象的handler，包含实际的业务处理逻辑 doService 以及一个自身成员对象，比如下面代码的 protected AbsHandler handler;
 * 这样在 Test类的main方法中只需要将handler1的成员对象handle设为handler2，handler2的设为handler3，
 * 然后handler1.doService(new Object())，就可以实现doService链式执行
 *
 *
 *
 */
public abstract class AbsHandler {

    protected AbsHandler handler;

    public AbsHandler getHandler() {
        return handler;
    }

    public void setHandler(AbsHandler handler) {
        this.handler = handler;
    }


    /**
     *
     * 具体的操作逻辑
     * @param param
     */
    abstract void doService(Object param);

}

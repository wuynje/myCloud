package com.tianhai.designMode.responsibilityChain;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 17:19
 * @Description:
 */
public class Tes {

    public static void test(String[] args) {
        AbsHandler handler1 = new OneHandlerImpl();
        AbsHandler handler2 = new TwoHandlerImpl();
        AbsHandler handler3 = new ThreeHandlerImpl();
        handler1.setHandler(handler2);
        handler2.setHandler(handler3);
        handler1.doService(new Object());
    }

}

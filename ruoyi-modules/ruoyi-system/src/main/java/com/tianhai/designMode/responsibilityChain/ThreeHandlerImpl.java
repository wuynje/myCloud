package com.tianhai.designMode.responsibilityChain;

/**
 * @Author: wuynje
 * @Date: 2021/7/19 17:10
 * @Description: 责任链模式的具体操作类三
 */
public class ThreeHandlerImpl extends AbsHandler {
    @Override
    void doService(Object param) {
        System.out.println("责任链模式，链三操作");
        System.out.println("责任链模式完成。。。。。");
    }
}

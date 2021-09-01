package com.tianhai.designMode.factory.factorymethod;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 17:19
 * @Description:
 */
public class Tes {

    public static void test(String[] args) {
        FactoryMethod factoryMethod = FactoryMethod.getFactory("one");
        factoryMethod.createProduct();
    }

}

package com.tianhai.designMode.factory.factorymethod;

import com.tianhai.designMode.factory.Product;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 15:13
 * @Description: 工厂方法
 *
 * 其实就是说白了再创建一个工厂，用来创建工厂类对象(根据类型不同创建不一样的对象工厂)
 * 有新的对象需要创建只需要新增对象工厂即可，便于扩展
 * 这样做的好处是允许创建产品的代码独立地变换，而不会影响到调用方。
 *
 */
public abstract class FactoryMethod {

    /**
     * 创建产品
     * @return
     */
    public abstract Product createProduct();


    // 获取工厂实例:
    public static FactoryMethod getFactory(String factoryTpe) {
        if(factoryTpe.equals("one")){
            return new ProductOneFactory();
        }else{
            return new ProductTwoFactory();
        }
    }



}

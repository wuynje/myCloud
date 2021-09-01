package com.tianhai.designMode.factory.factorymethod;

import com.tianhai.designMode.factory.Product;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 16:46
 * @Description:产品工厂
 */
public class ProductOneFactory extends FactoryMethod {
    @Override
    public Product.Product1 createProduct() {
        return new Product.Product1();
    }

}

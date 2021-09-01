package com.tianhai.designMode.factory.simplefactory;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 11:15
 * @Description:简单工厂
 *
 *
 *
 */
public class SimpleFactory {

    /**
     * 缺点：每次创建一种新类型的对象就得去修改代码
     * 所以可以通过反射或者map的方式去修改这个缺点
     *
     * @param type
     * @return
     */
    public Object getObject(String type){
        if(type.equals("product1")){
            return "product1";
        }
        if(type.equals("product2")){
            return "product2";
        }
        else{
            return "defaultProduct";
        }
    }

}

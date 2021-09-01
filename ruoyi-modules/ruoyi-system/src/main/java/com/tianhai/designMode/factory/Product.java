package com.tianhai.designMode.factory;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 15:30
 * @Description:产品类
 */
public class Product {

    private String name;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 产品的实际业务逻辑等
     */
    public void processBusiness(){

    }

    public static class Product1 extends Product{
        @Override
        public void processBusiness(){
            //.....
        }
    }

    public static class Product2 extends Product{
        @Override
        public void processBusiness(){
            //.....
        }
    }


}

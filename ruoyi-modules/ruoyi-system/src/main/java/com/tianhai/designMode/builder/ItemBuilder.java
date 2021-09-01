package com.tianhai.designMode.builder;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 20:00
 * @Description: 建造者模式
 *
 * 建造者模式和工厂模式思想上的区别是：
 * 建造者模式的对象不同（比如都是商品但是区分虚拟和实际商品）
 * 工厂模式生成的对象都是同一种
 *
 */
public abstract class ItemBuilder {

    public abstract void createItem1();

    public abstract void createItem2();

    public abstract Item getItem();

}

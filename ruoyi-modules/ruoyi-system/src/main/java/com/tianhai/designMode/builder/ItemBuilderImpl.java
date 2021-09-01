package com.tianhai.designMode.builder;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 20:09
 * @Description:建造者实现类
 */
public class ItemBuilderImpl extends ItemBuilder {

    private Item item;

    @Override
    public void createItem1() {
        item = new Item();
        getItem().setCode("item1");
        getItem().setName("item1");
        getItem().setType("item1");
    }

    @Override
    public void createItem2() {
        getItem().setCode("item2");
        getItem().setName("item2");
        getItem().setType("item2");
        getItem().setUrl("www.baidu.com");
    }

    @Override
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

package com.tianhai.designMode.builder;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 20:28
 * @Description: 导演
 */
public class ItemDirector {
    private ItemBuilder itemBuilder;

    public ItemDirector(ItemBuilder itemBuilder){
        this.itemBuilder = itemBuilder;
    }

    public Item getItem1(){
        itemBuilder.createItem1();
        return itemBuilder.getItem();
    }

    public Item getItem2(){
        itemBuilder.createItem2();
        return itemBuilder.getItem();
    }

    public static void test(String[] args) {
        ItemDirector itemDirector = new ItemDirector(new ItemBuilderImpl());
        itemDirector.getItem1();
        itemDirector.getItem2();
    }


}

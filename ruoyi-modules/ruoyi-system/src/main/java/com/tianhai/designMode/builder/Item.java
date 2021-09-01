package com.tianhai.designMode.builder;

/**
 * @Author: wuynje
 * @Date: 2021/7/14 20:01
 * @Description:要被创建的Item(此item包含4个属性，但是可能不同类型的item的属性不同，比如Item
 * 是一个商品，可能是虚拟商品，可能是实体商品，比如虚拟商品可能会有url属性，但是实体商品不需要。)
 *
 *
 * 建造者模式最新写法可以是链式的，自行搜索
 */
public class Item {

    private String name;

    private String type;

    private String code;

    private String url;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.tianhai.designMode.strategy;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 16:16
 * @Description:
 */
public class GearStrategyOne implements GearStrategy {

    @Override
    public void algorithm(String param) {
        System.out.println("当前档位" + param);
    }
}
package com.tianhai.designMode.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wuynje
 * @Date: 2021/7/22 16:16
 * @Description: 一种是把所有的策略缓存在map中，用的时候根据key去拿，另一种就是直接if else
 */
public class Context {
    // 缓存所有的策略，当前是无状态的，可以共享策略类对象
    private static final Map<String, GearStrategy> strategies = new HashMap<>();

    // 第一种写法
    static {
        strategies.put("one", new GearStrategyOne());
    }

    public static GearStrategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }

    // 第二种写法
    public static GearStrategy getStrategySecond(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals("one")) {
            return new GearStrategyOne();
        }
        return null;
    }


    public static void test(String[] args) {
        // 测试结果
        GearStrategy strategyOne = Context.getStrategy("one");
        strategyOne.algorithm("1档");
        // 结果：当前档位1档
        GearStrategy strategyTwo = Context.getStrategySecond("one");
        strategyTwo.algorithm("1档");
        // 结果：当前档位1档
    }

}

package com.tianhai.designMode.singleton;

/**
 * 单例模式
 *
 * @Author: wuynje
 * @Date: 2021/7/13 10:17
 * @Description: 单例特征
 * 单例模式能保证在一个JVM中，该对象只有一个实例存在
 * 构造器必须是私有的，外部类无法通过调用构造器方法创建该实例
 * 没有公开的set方法，外部类无法调用set方法创建该实例
 * 提供一个公开的get方法获取唯一的这个实例
 */
public class Singleton {

    private Singleton() {

    }

    /**
     * 饿汉式
     */
    private static Singleton instance1 = new Singleton();

    public static Singleton getInstance1() {
        return instance1;
    }

    /**
     * 懒汉式（非线程安全）
     */
    private static Singleton instance2;

    public static Singleton getInstance2() {
        if (instance2 == null) {
            instance2 = new Singleton();
        }
        return instance2;
    }


    /**
     * 懒汉式（线程安全）
     */
    private static Singleton instance3;

    public static Singleton getInstance3() {
        if (instance3 == null) {
            synchronized (Singleton.class) {
                if (instance3 == null) {
                    instance3 = new Singleton();
                }
            }
        }
        return instance3;
    }

    /**
     * 懒汉式（线程安全）
     */

    //当一个变量被 volatile 修饰时，任何线程对它的写操作都会立即刷新到主内存中，
    // 并且会强制让缓存了该变量的线程中的数据清空，必须从主内存重新读取最新数据。
    //内存可见性只是 volatile 的其中一个语义，它还可以防止 JVM 进行指令重排优化。
    private static volatile Singleton instance4;

    public static Singleton getInstance4() {
        if (instance4 == null) {
            synchronized (Singleton.class) {
                if (instance4 == null) {
                    //由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，
                    // 并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
                    //B进入synchronized块，由于instance此时不是null，
                    // 因此它马上离开了synchronized块并将结果返回给调用该方法的程序。

                    //所以要给instance加volatile防止指令重排
                    instance4 = new Singleton();
                }
            }
        }
        return instance4;
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {
        private static Singleton instance5 = new Singleton();
    }

    /* 获取实例 */
    public static Singleton getInstance5() {
        return SingletonFactory.instance5;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance5();
    }

    //最后，使用枚举，
    public enum SingletonEnum{
        instance1;
    }


}

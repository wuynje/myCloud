package com.tianhai.jvm;

/**
 * @Author: wuynje
 * @Date: 2021/9/27 22:22
 * @Description:
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = null;
        return this.defineClass("myclassloader",b,0,1);
    }
}

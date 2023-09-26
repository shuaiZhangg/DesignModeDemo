package com.zhangshuai.reflect;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/25
 * @Description:
 * @Version: 1.0
 */
public class TestClass {

    @Test
    public void test01() throws ClassNotFoundException {
        Class class01 = Cat.class;
        System.out.println(class01.getName());//全类名
        System.out.println(class01.getSimpleName());//类名

        Cat cat = new Cat();
        Class<? extends Cat> class02 = cat.getClass();
        Class<?> class03 = Class.forName("com.zhangshuai.reflect.Cat");

        System.out.println(class01 == class03);
        System.out.println(class03 == class02);
    }
}

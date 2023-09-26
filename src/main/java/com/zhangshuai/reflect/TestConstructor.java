package com.zhangshuai.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/25
 * @Description:
 * @Version: 1.0
 */
public class TestConstructor {

    /**
     * 获取类的构造器方法
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        Class class01 = Cat.class;
        //1.无参数构造
        Constructor constructor = class01.getDeclaredConstructor();
        System.out.println(constructor.getName()  + " ->>>>> " + constructor.getParameterCount());
        constructor.setAccessible(true);
        Object o = constructor.newInstance();
        System.out.println(o);
        //2.根据参数获取有参构造方法
        Constructor constructor1 = class01.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor1.getName()  + " ->>>>> " + constructor1.getParameterCount());

    }
}

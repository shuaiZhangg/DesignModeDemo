package com.zhangshuai.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/25
 * @Description:
 * @Version: 1.0
 */
public class TestField {

    @Test
    public void test01() throws Exception {
        Class<Cat> catClass = Cat.class;

        Field field = catClass.getDeclaredField("name");

        Cat cat = new Cat();
        field.setAccessible(true);
        field.set(cat,"咖啡猫");
        System.out.println(field.get(cat));
    }
}

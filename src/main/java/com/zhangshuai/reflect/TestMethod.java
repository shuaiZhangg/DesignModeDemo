package com.zhangshuai.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/26
 * @Description:
 * @Version: 1.0
 */
public class TestMethod {

    @Test
    public void test01() throws Exception {
        Class<Cat> aClass = Cat.class;
        Method method = aClass.getDeclaredMethod("run");

        System.out.println("方法名：" + method.getName() + ", 返回类型："+method.getReturnType());

        Cat cat = new Cat();
        method.setAccessible(true);//暴力反射开启访问权限
        Object invoke = method.invoke(cat);//通过反射执行方法
        System.out.println(invoke);
    }
}

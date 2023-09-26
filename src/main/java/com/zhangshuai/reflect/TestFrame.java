package com.zhangshuai.reflect;

import org.junit.Test;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/26
 * @Description:
 * @Version: 1.0
 */
public class TestFrame {

    @Test
    public void test01() throws Exception {
        Cat cat = new Cat("咖啡猫",10);
        Student student = new Student("lisi",20);
        ObjectFrame.saveObject(cat);
        ObjectFrame.saveObject(student);


    }
}

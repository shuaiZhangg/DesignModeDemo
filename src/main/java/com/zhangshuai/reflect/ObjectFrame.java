package com.zhangshuai.reflect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/26
 * @Description:
 * @Version: 1.0
 */
public class ObjectFrame {

    public static void saveObject(Object obj) throws Exception {
        //打印到文件
        PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/data.txt",true));

        Class c = obj.getClass();
        //获取类名称
        String cName = c.getSimpleName();
        ps.println("---------------------" + cName + "-------------------");

        //反射获取所有成员属性
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            field.setAccessible(true);//开启暴力反射
            String value = field.get(obj) + "";
            ps.println(name + "=" + value);
        }
    }
}

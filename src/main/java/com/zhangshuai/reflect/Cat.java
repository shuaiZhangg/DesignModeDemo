package com.zhangshuai.reflect;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/9/25
 * @Description:
 * @Version: 1.0
 */

public class Cat {

    private String name;
    private int age;

    public Cat(){
        System.out.println("abc.....");
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void run(){
        System.out.println("跑得快！！");
    }

    public void eat(){
        System.out.println("吃饱了");
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

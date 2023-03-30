package com.zhangshuai.designMode;

public class Book {

    public static void main(String[] args) {
        staticFunction();
    }

    //1 static Book book = new Book();触发了类的实例化 JVM 执行对象构造器
    //2 JVM 执行对象构造器 会按照收集成员变量的赋值语句、普通代码块，最后收集构造方法，将它们组成对象构造器，最终由 JVM 执行
    static Book book = new Book(); //初始化为null
    static {
        System.out.println("书的静态代码块");// 4
    }
    {
        System.out.println("书的普通代码块");// 1
    }
    Book(){
        System.out.println("书的构造方法");// 2
        System.out.println(price+amount);// 3  12+0
    }

    public static void staticFunction(){
        System.out.println("书的静态方法");// 5
    }
    int price = 12;
    static int amount= 110; // 初始化为0


    /**
     * 1、确定类变量的初始值。在类加载的准备阶段，JVM 会为类变量初始化零值，这时候类变量会有一个初始的零值。如果是被 final 修饰的类变量，则直接会被初始成用户想要的值。
     *
     * 2、初始化入口方法。当进入类加载的初始化阶段后，JVM 会寻找整个 main 方法入口，从而初始化 main 方法所在的整个类。当需要对一个类进行初始化时，会首先初始化类构造器（），之后初始化对象构造器（）。
     *
     * 3、初始化类构造器。JVM 会按顺序收集类变量的赋值语句、静态代码块，最终组成类构造器由 JVM 执行。
     *
     * 4、初始化对象构造器。JVM 会按照收集成员变量的赋值语句、普通代码块，最后收集构造方法，将它们组成对象构造器，最终由 JVM 执行。
     *
     */
}

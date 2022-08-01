package com.zhangshuai.designMode.proxy.JdkProxy;

import com.zhangshuai.designMode.proxy.JdkProxy.IProduct;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class Product implements IProduct {
    @Override
    public String sell(Float money) {
        System.out.println("代理员交给工厂："+money);
        return "aaa";
    }
    @Override
    public void afterSell() {
        System.out.println("代理员做售后。。");
    }

    public static void main(String[] args) {

    }
}
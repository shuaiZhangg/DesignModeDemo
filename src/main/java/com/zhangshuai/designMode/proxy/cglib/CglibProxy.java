package com.zhangshuai.designMode.proxy.cglib;

import com.zhangshuai.designMode.proxy.JdkProxy.Product;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {
    public static void main(final String[] args) {
        // 创建一个被代理对象，这里要求必须是final
        final Product product = new Product();

        Product proxyProduct = (Product) Enhancer.create(product.getClass(), new MethodInterceptor() {

            /**
             *
             * @param o
             * @param method 当前方法
             * @param objects 方法用到的参数数组
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) objects[0];
                Object returnValue = null;
                if ("sell".equals(method.getName())) {
                    returnValue = method.invoke(product, 0.8f * money);
                }
                return returnValue;
            }
        });
        System.out.println(proxyProduct.sell(1000f));

    }
}
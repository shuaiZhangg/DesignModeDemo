package com.ctfo.ribao.test.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {
    public static void main(String[] args) {
        // 创建一个被代理对象
        final Product product = new Product();

        /**
         * ClassLoader loader获取被代理类的类加载器。
         * Class<?>[] interfaces获取被代理类的实现接口的数组。
         * InvocationHandler 在invoke方法中对方法做增强处理。
         */
        // 创建一个代理对象，并在InvocationHandler的invoke方法里面，对被代理类的方法做增强
        IProduct proxyProduct = (IProduct) Proxy.newProxyInstance(product.getClass().getClassLoader(), product.getClass().getInterfaces(), new InvocationHandler() {



            /**
             *
             * @param proxy 当前代理对象
             * @param method 当前方法
             * @param args 方法传递的参数
             * @return
             * @throws Throwable
             */
            // 实现具体的增强操作
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 获取方法在运行中可能产生的返回值
                Object returnValue = null;
                Float money = 0.0F;
                if(null != args) {
                     money = (Float) args[0];
                }
                if("sell".equals(method.getName())){
                    // 执行具体的方法
                    returnValue = method.invoke(product, money*0.8F);
                }
                return this;
            }
        });
        proxyProduct.sell(1000.0F);
    }
}
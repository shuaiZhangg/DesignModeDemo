# 适配器模式

试例代码：

```java
package com.zhangshuai.designMode.adapter.v2;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2022/08/01
 * @Description: TODO
 * @Version: 1.0
 */
public class AdapterExtends {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.output5v();
    }
}

class Source{
    public int output220v(){
        return 220;
    }
}

interface Target{
    int output5v();
}

class Adapter extends Source implements Target{

    @Override
    public int output5v() {
        int i = super.output220v();
        //...........
        System.out.println(String.format("输入电压 %d v  ->  输出电压 %d v ",i,5));
        return 0;
    }
}
```



## 应用场景

1. 当你希望使用某些现有类，但其接口与您的其它代码不兼容时，请使用适配器模式
2. 当你希望重用几个现有的子类，这些子类缺少一些不能添加到超类的公共功能时，请使用适配器模式



## JDK & Spring源码中的应用

```java
JDK
java.util.Arrays#asList();
java.util.Collections#list();

Spring
org.springframework.context.event.GenericApplicationListenerAdapter
```


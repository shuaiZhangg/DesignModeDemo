package com.zhangshuai.designMode.template;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2023/3/1
 * @Description: 模版方法：定义一个抽象类来制定骨架，使用子类来继承并实现子类的业务逻辑
 * @Version: 1.0
 */
public abstract class TemplateMethod {

    public static void main(String[] args) {
        TemplateMethod method = new subClass();
        method.operation();
    }

    public void operation(){
        //搭建骨架
        System.out.println(" pre.....");
        System.out.println(" todo1.....");
        System.out.println(" todo2.....");

        Object o = operationTemplate();
        System.out.println(o);
    }

    protected abstract Object operationTemplate();
}

class subClass extends TemplateMethod{

    @Override
    protected Object operationTemplate() {
        return "处理业务1";
    }
}

class subClass1 extends TemplateMethod{

    @Override
    protected Object operationTemplate() {
        return "处理业务2";
    }
}

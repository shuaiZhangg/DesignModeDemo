package com.zhangshuai.designMode.adapter.v1;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2022/08/01
 * @Description: Object Adapter 对象适配器模式
 * @Version: 1.0
 */
public class AdapterObject{
    public static void main(String[] args) {
        Source source = new Source();
        Target target = new Adapter(source);
        target.output5V();

    }
}

class Source {
    public int output220V(){
        return 220;
    }
}
interface Target {
    int output5V();
}

class Adapter implements Target{

    private Source source;

    public Adapter(Source source) {
        this.source = source;
    }

    @Override
    public int output5V() {
        int i = source.output220V();

        //............

        System.out.println(String.format("输入电压 %d v  ->  输出电压 %d v ",i,5));
        return 5;
    }
}

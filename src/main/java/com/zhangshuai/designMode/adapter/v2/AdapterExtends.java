package com.zhangshuai.designMode.adapter.v2;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2022/08/01
 * @Description: 适配器方式二
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
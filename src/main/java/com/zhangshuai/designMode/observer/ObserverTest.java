package com.zhangshuai.designMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Shuai Zhang
 * @CreateTime: 2022/08/01
 * @Description: Observer 观察者模式
 * @Version: 1.0
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer task1 = new Task1();
        subject.add(task1);
        Observer task2 = new Task2();
        subject.add(task2);

        subject.notifyObserver("xxxxx");
        System.out.println("------------");
        subject.remove(task1);
        subject.notifyObserver("xxxxxxxxxx");
    }
}

class Subject{
    public List<Observer> observerList = new ArrayList<>();

    public void add(Observer observer){
        observerList.add(observer);
    }

    public void remove(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObserver(Object o){
        for (Observer observer : observerList) {
            observer.update(o);
        }
    }
}

interface Observer{
    void update(Object o);
}

class Task1 implements Observer{

    @Override
    public void update(Object o) {
        System.out.println("Task1 ...." + o);
    }
}

class Task2 implements Observer{

    @Override
    public void update(Object o) {
        System.out.println("Task2 ...." + o);
    }
}
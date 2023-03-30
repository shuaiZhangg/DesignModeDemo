package com.zhangshuai.designMode.builder;

/**
 * "Abstract Builder"
 * 提供创建不同披萨的底料
 */
public abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();

    public abstract void buildSauce();

    public abstract void buildTopping();
}
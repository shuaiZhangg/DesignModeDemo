package com.ctfo.ribao.test.Jianzaozhe;

/**
 * "ConcreteBuilder"
 * 需要构建的披萨
 */
class SpicyPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("pan baked");
    }

    public void buildSauce() {
        pizza.setSauce("hot");
    }

    public void buildTopping() {
        pizza.setTopping("pepperoni+salami");
    }
}
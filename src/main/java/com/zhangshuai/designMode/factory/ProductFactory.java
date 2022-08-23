package com.ctfo.ribao.test.shejimoshi;

/**
 *
 * @param null
 * @return 11
 */

interface Product  {
    void method();
}

abstract class ProductFactory{
    abstract Product createProduct();
}

class ProductApple implements Product{

    @Override
    public void method() {
        System.out.println("method");
    }
}
class ProductOrange implements Product{

    @Override
    public void method() {
        System.out.println("method.....");
    }
}

class Apple extends ProductFactory {

    @Override
    Product createProduct() {
        // ...
        return new ProductApple();
    }
}


class Orange extends ProductFactory {

    @Override
    Product createProduct() {
        // ...
        return new ProductOrange();
    }
}


class FactoryTest {
    public static void main(String[] args) {
        ProductFactory factory = new Apple();
        Product product = factory.createProduct();
        product.method();
    }
}

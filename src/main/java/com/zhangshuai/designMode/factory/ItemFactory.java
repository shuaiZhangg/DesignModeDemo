package com.ctfo.ribao.test.shejimoshi;

/**
 * 简单工厂模式就是工厂类提供一个方法，根据传入参数的不同，返回具体的实现类。
 */
class Item {}
class AgedWine extends Item {}
class ShowTicket extends Item {}
class Cure extends Item {}

public class ItemFactory {
    public static Item createItem(String type) {
        if (type.equals("AgedWine")) {
            return new AgedWine();
        } else if (type.equals("ShowTicket")) {
            return new ShowTicket();
        } else if (type.equals("Cure")) {
            return new Cure();
        } else {
            return null;
        }
    }
}


package com.gself.study.jpattern.factory.simpleFactory;

/**
 * Created by gtt on 2020/3/17.
 */
public class OrderShop1 {
    PizzaFactory factory = new PizzaFactory();
    public Pizza order(String type){
        Pizza pizza = factory.create(type);
        return pizza;
    }
}

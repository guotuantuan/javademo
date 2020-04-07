package com.gself.study.jpattern.factory.factoryMethod;

import com.gself.study.jpattern.factory.simpleFactory.CheesePizza;
import com.gself.study.jpattern.factory.simpleFactory.Pizza;

/**
 * Created by gtt on 2020/3/17.
 */
public class OrderShopM1 extends AbstractOrderShop {
    @Override
    public Pizza create() {
        Pizza pizza = new CheesePizza();
        pizza.setName("Cheese");
        return pizza;
    }
}

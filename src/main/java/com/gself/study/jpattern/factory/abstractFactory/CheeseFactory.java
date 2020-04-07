package com.gself.study.jpattern.factory.abstractFactory;

import com.gself.study.jpattern.factory.simpleFactory.CheesePizza;
import com.gself.study.jpattern.factory.simpleFactory.Pizza;

/**
 * Created by gtt on 2020/3/17.
 */
public class CheeseFactory implements PizzaFactoryInterface {
    @Override
    public Pizza create() {
        Pizza pizza = new CheesePizza();
        pizza.setName("Cheese");
        return pizza;
    }
}

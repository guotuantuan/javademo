package com.gself.study.jpattern.factory.abstractFactory;

import com.gself.study.jpattern.factory.simpleFactory.GreekPizza;
import com.gself.study.jpattern.factory.simpleFactory.Pizza;

/**
 * Created by gtt on 2020/3/17.
 */
public class GreekFactory implements PizzaFactoryInterface {
    @Override
    public Pizza create() {
        Pizza pizza = new GreekPizza();
        pizza.setName("Greek");
        return pizza;
    }
}

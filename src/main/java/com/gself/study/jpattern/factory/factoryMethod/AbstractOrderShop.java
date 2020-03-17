package com.gself.study.jpattern.factory.factoryMethod;

import com.gself.study.jpattern.factory.simpleFactory.Pizza;

/**
 * Created by gtt on 2020/3/17.
 */
public abstract class AbstractOrderShop {

    public abstract Pizza create();
    public Pizza order(String type){
        Pizza pizza = create();
        return pizza;
    }
}

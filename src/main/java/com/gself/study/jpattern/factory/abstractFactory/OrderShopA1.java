package com.gself.study.jpattern.factory.abstractFactory;

import com.gself.study.jpattern.factory.simpleFactory.Pizza;

/**
 * Created by gtt on 2020/3/17.
 */
public class OrderShopA1 {
    PizzaFactoryInterface pfi;

    public void setFactory(PizzaFactoryInterface pfi){
        this.pfi = pfi;
    }

    public Pizza order(){
        return pfi.create();
    }
}

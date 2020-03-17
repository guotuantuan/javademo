package com.gself.study.jpattern.factory.simpleFactory;

/**
 * Created by gtt on 2020/3/17.
 *
 * 简单工厂方法    也称为静态工厂方法
 */
public class PizzaFactory {

    public Pizza create(String type){
        Pizza pizza = null;
        if(type.equals("Greek")){
            pizza =  new GreekPizza();
            pizza.setName("Greek");
        }else if(type.equals("Cheese")){
            pizza =  new CheesePizza();
            pizza.setName("Cheese");
        }
        return pizza;
    }
}

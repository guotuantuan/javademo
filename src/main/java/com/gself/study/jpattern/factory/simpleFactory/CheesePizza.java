package com.gself.study.jpattern.factory.simpleFactory;

/**
 * Created by gtt on 2020/3/17.
 */
public class CheesePizza extends Pizza {


    @Override
    void prepare() {
        System.out.println("cheese compareing...");
    }
}

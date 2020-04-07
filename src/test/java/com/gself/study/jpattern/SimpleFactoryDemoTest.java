package com.gself.study.jpattern;

import com.gself.study.jpattern.factory.simpleFactory.OrderShop1;
import com.gself.study.jpattern.factory.simpleFactory.Pizza;
import com.gself.study.jpattern.factory.simpleFactory.PizzaFactory;
import org.junit.Test;

/**
 * Created by gtt on 2020/3/17.
 */
public class SimpleFactoryDemoTest {

    @Test
    public void test(){
        OrderShop1 orderShop1 = new OrderShop1();
        Pizza pizza = orderShop1.order("Greek");
        System.out.println(pizza);
        Pizza pizza2 = orderShop1.order("Cheese");
        System.out.println(pizza2);
    }
}

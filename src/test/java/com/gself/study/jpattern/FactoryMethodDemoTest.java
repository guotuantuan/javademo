package com.gself.study.jpattern;

import com.gself.study.jpattern.factory.factoryMethod.AbstractOrderShop;
import com.gself.study.jpattern.factory.factoryMethod.OrderShopM1;
import com.gself.study.jpattern.factory.simpleFactory.Pizza;
import org.junit.Test;

/**
 * Created by gtt on 2020/3/17.
 */
public class FactoryMethodDemoTest {

    @Test
    public void test(){
        AbstractOrderShop abstractOrderShop = new OrderShopM1();
        Pizza pizza = abstractOrderShop.create();
        System.out.println(pizza);
    }
}

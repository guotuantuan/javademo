package com.gself.study.jpattern;

import com.gself.study.jpattern.factory.abstractFactory.GreekFactory;
import com.gself.study.jpattern.factory.abstractFactory.OrderShopA1;
import com.gself.study.jpattern.factory.simpleFactory.Pizza;
import org.junit.Test;

/**
 * Created by gtt on 2020/3/17.
 */
public class AbstractFactoryDemoTest {

    @Test
    public void test(){
        OrderShopA1 orderShopA1 = new OrderShopA1();
        orderShopA1.setFactory(new GreekFactory());
        Pizza pizza = orderShopA1.order();
        System.out.println(pizza);
    }
}

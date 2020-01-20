package com.gself.study.jpattern;

import com.gself.study.jpattern.decoration.*;
import org.junit.Test;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 15:52
 */
public class DecorationDemoTest {
    /**
     * 装饰者模式测试
     */
    @Test
    public void test01(){
        Beverage beverage = new MilkTea();
        beverage = new Ice(beverage);
        beverage = new Peal(beverage);
        beverage = new Sugar(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.coast());
    }

    @Test
    public void test02(){
        Beverage beverage = new MilkTea();
        beverage = new Ice(beverage);
        beverage = new Peal(beverage);
        beverage = new Sugar(beverage);
        beverage = new BigCup(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.coast());
    }
}

package com.gself.study.jpattern.decoration;

/**
 * @Author:gtt
 * @Description cup:杯子
 * @Date: 2020/1/20 15:55
 */
public class SmallCup implements Beverage{

    Beverage beverage;
    public SmallCup(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" small";
    }

    @Override
    public int coast() {
        return beverage.coast();
    }
}

package com.gself.study.jpattern.decoration;

/**
 * @Author:gtt
 * @Description cup:杯子
 * @Date: 2020/1/20 15:55
 */
public class BigCup implements Beverage{

    Beverage beverage;

    public BigCup(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" big";
    }

    @Override
    public int coast() {
        return beverage.coast()+3;
    }
}

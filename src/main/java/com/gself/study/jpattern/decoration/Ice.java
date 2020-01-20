package com.gself.study.jpattern.decoration;

/**
 * @Author:gtt
 * @Description ice:冰
 * @Date: 2020/1/20 15:36
 */
public class Ice implements Beverage {

    Beverage beverage;

    public Ice(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" ice";
    }

    @Override
    public int coast() {
        return beverage.coast()+1;
    }
}

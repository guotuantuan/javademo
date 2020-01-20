package com.gself.study.jpattern.decoration;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 15:36
 */
public class Sugar implements Beverage {

    Beverage beverage;

    public Sugar(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" sugar";
    }

    @Override
    public int coast() {
        return beverage.coast()+2;
    }
}

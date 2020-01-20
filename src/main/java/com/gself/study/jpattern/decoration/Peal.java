package com.gself.study.jpattern.decoration;

/**
 * @Author:gtt
 * @Description  peal:珍珠
 * @Date: 2020/1/20 15:37
 */
public class Peal implements Beverage {

    Beverage beverage;

    public Peal(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" peal";
    }

    @Override
    public int coast() {
        return beverage.coast()+3;
    }
}

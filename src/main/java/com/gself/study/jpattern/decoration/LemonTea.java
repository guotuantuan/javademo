package com.gself.study.jpattern.decoration;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 15:48
 */
public class LemonTea implements Beverage {


    @Override
    public String getDescription() {
        return "lemontea";
    }

    @Override
    public int coast() {
        return 16;
    }
}

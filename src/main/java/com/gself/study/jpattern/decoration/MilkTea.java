package com.gself.study.jpattern.decoration;

import java.util.Map;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 15:39
 */
public class MilkTea implements Beverage{


    @Override
    public String getDescription() {
        return "milktea";
    }

    @Override
    public int coast() {
        return 15;
    }
}

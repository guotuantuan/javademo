package com.gself.study.jtype;

import java.math.BigDecimal;

/**
 * Created by gtt on 2020/4/27.
 */
public class ShuZiDemo {

    public void test(){
        Integer a = 9;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Float.MAX_VALUE);

    }

    public void decimal(){
        BigDecimal a = new BigDecimal(28.62);
        BigDecimal b = new BigDecimal(  500);
        BigDecimal c = a.add(b);
        System.out.println(c);

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(a.compareTo(a));

        BigDecimal d = new BigDecimal(10.00010);
        BigDecimal e = new BigDecimal(1);
        System.out.println(d.divide(e,3,BigDecimal.ROUND_FLOOR));

        BigDecimal d2 = new BigDecimal(2.4);
        BigDecimal d3 = BigDecimal.valueOf(2.3);
        BigDecimal d4 = new BigDecimal(Double.toString(2.3));
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);


    }
}

package com.gself.study.jcompare;

import java.util.Comparator;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 11:31
 */
public class ComparatorDemo  implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1>o2?1:-1;
    }
}

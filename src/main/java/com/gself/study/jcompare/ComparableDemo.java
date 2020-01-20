package com.gself.study.jcompare;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 11:36
 */
public class ComparableDemo implements Comparable<ComparableDemo> {

    public int index;

    public ComparableDemo(int index){
        this.index = index;
    }

    /**
     * 从小到大排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(ComparableDemo o) {
        return o.index<this.index?1:-1;
    }
}

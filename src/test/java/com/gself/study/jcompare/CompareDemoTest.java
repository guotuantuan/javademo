package com.gself.study.jcompare;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 11:39
 */
public class CompareDemoTest {

    /**
     * Comparable接口测试
     */
    @Test
    public void test01(){
        ComparableDemo cd0 = new ComparableDemo(3);
        ComparableDemo cd1 = new ComparableDemo(2);
        ComparableDemo cd2 = new ComparableDemo(4);
        ComparableDemo cd3 = new ComparableDemo(1);
        ComparableDemo cd4 = new ComparableDemo(5);
        ComparableDemo[] cdArr = new ComparableDemo[5];
        cdArr[0] = cd0;
        cdArr[1] = cd1;
        cdArr[2] = cd2;
        cdArr[3] = cd3;
        cdArr[4] = cd4;
        Arrays.sort(cdArr);
        for(int i=0;i<cdArr.length;i++){
            System.out.println(cdArr[i].index);
        }
    }


    /**
     * Comparator接口测试
     */
    @Test
    public void test02(){
        Integer[] cdArr = new Integer[5];
        cdArr[0] = 2;
        cdArr[1] = 5;
        cdArr[2] = 3;
        cdArr[3] = 1;
        cdArr[4] = 4;
        Arrays.sort(cdArr,new ComparatorDemo());
        for(Integer in:cdArr){
            System.out.println(in);
        }
    }
}

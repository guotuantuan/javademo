package com.gself.study.jtype;

import org.junit.Test;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/9 16:16
 */
public class CollectionDemoTest {

    @Test
    public void test(){
        CollectionDemo cdemo = new CollectionDemo();
        cdemo.listToArray();
    }

    @Test
    public void test2(){
        CollectionDemo cdemo = new CollectionDemo();
        cdemo.arrayToList();
    }

    @Test
    public void test3(){
        CollectionDemo cdemo = new CollectionDemo();
        cdemo.sortList();
    }

    @Test
    public void test4(){
        CollectionDemo cdemo = new CollectionDemo();
        cdemo.sortArray();
    }
}

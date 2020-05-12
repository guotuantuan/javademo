package com.gself.study.jcollection;

import org.junit.Test;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by gtt on 2020/5/2.
 */
public class CollectionDemoTest {

    @Test
    public void test()throws Exception{
        HashMapDemo demo = new HashMapDemo();
    }
    @Test
    public void test2()throws Exception{
        HashMapDemo demo = new HashMapDemo();
        demo.hashMap();
    }

    @Test
    public void test3()throws Exception{
        HashMapDemo demo = new HashMapDemo();
        demo.hashMapDebug();
    }

    @Test
    public void test4()throws Exception{
        HashMapDemo demo = new HashMapDemo();
        demo.unSafeTest();
    }

    @Test
    public void test5()throws Exception{
        HashMapDemo demo = new HashMapDemo();
        demo.reflection();

    }
    @Test
    public void test6()throws Exception{
        HashMapDemo demo = new HashMapDemo();
        demo.synchronizedMap();


    }


}

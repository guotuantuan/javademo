package com.gself.study.jthread;

import com.gself.study.jthread.pool.ThreadPoolDemo;
import org.junit.Test;

/**
 * Created by gtt on 2020/5/1.
 */
public class ThreadPoolDemoTest {

    @Test
    public void test()throws Exception{
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.poolDemo();
    }

}

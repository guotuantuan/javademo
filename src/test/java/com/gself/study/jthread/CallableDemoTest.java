package com.gself.study.jthread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/7 17:05
 */
public class CallableDemoTest {

    @Test
    public void test1()throws Exception {
        ExecutorService exe = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future<Integer> r1 = exe.submit(new CallableDemo().new CallInner(i));
            Future<Integer> r2 = exe.submit(new CallableDemo().new CallInner(i));
            System.out.println("r1:" + r1.get());
            System.out.println("r2:"+r2.get());

        }
    }


}

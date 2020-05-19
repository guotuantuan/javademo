package com.gself.study.jthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author:gtt
 * @Description   带返回值的线程  返回方法get会阻塞方法运行，直到get到返回值，才向下执行方法，
 *
 * @Date: 2020/5/15 10:53
 */
public class SubmitThreadDemo {

    public void test()throws Exception{
        FutureTask c1  = new FutureTask(new CallableDemo().new CallInner(1));
        FutureTask c2  = new FutureTask(new CallableDemo().new CallInner(2));
//        CallableDemo.CallInner c1 = new CallableDemo().new CallInner(1);
//        CallableDemo.CallInner c2 = new CallableDemo().new CallInner(2);
        ExecutorService exe = Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        exe.submit(c1);
        exe.submit(c2);
//        c1.get();

        System.out.println(123);

        System.out.println(c2.get());

        System.out.println(456);

        Thread.sleep(50*1000);
    }

}

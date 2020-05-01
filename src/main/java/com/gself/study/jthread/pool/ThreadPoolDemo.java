package com.gself.study.jthread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gtt on 2020/5/1.
 */
public class ThreadPoolDemo {



    /**
     * 自定义线程池demo  避免oom
     */
    public void poolDemo()throws Exception{
        ExecutorService exe = CustomThreadPool.newCustomThreadPool(3);
//        ExecutorService exe = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            ThreadDemo demo = new ThreadDemo(i);
            demo.join();
            exe.execute(demo);
            ThreadDemo.print(i+"===");
        }
        Thread.sleep(200*1000);
    }

}

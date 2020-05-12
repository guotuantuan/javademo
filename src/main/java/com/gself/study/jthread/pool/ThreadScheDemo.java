package com.gself.study.jthread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author:gtt
 * @Description  定时任务线程池单个线程卡住，导致定时任务不执行问题
 * 注意spring 使用@Scheduled 为单线程定时线程，当其中一个线程卡住的时候，其他线程也不能按时执行，只能等卡住的线程通过后才能执行定时任务
 *
 * 解决办法，应用场景中，增加超时断开设置，防止线程阻塞
 * @Date: 2020/5/11 14:11
 */
public class ThreadScheDemo {

    public void test()throws Exception{
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
//        service.schedule(new ScheInner(),1, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new ScheInner(),0,2,TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(new ScheInner2(),0,3,TimeUnit.SECONDS);

        TimeUnit.MINUTES.sleep(30);
    }

    class ScheInner implements Runnable{
        @Override
        public void run() {
            try{
                //设置休眠时间10S，导致其他定时任务也不能执行
                TimeUnit.SECONDS.sleep(10);
            }catch (Exception e){

            }
            System.out.println(new Date()+"---1");
        }
    }
    class ScheInner2 implements Runnable{
        @Override
        public void run() {
            System.out.println(new Date()+"---2");
        }
    }

}

package com.gself.study.jthread.pool;

import java.util.concurrent.*;

/**
 * Created by gtt on 2020/5/1.
 *
 * 自定义线程池，拒绝策略为阻塞式重新加入队列
 *
 */
public class CustomThreadPool {
    public static ExecutorService newCustomThreadPool(int nTheads){
        return new ThreadPoolExecutor(nTheads,nTheads,0L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(5),new CustomRejectExcutionHandler());
    }



    //自定义拒绝策略
    private static class CustomRejectExcutionHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try{
                executor.getQueue().put(r);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}

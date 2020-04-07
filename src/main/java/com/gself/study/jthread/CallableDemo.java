package com.gself.study.jthread;

import java.util.concurrent.*;

/**
 * @Author:gtt
 * @Description 带返回值的线程
 * @Date: 2020/4/7 9:23
 */
public class CallableDemo {



    class CallInner implements Callable<Integer>{
        private Integer index;
        public CallInner(Integer index){
            this.index = index;
        }
        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return index;
        }
    }
}

package com.gself.study.jthread.InheribleDemo;

import com.gself.study.jthread.InheribleDemo.RunTask;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by guotuantuan on 2020/9/8 16:24
 */
public  class InheriDemo {

    static InheritableThreadLocal<String> local;
    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException {

        ExecutorService service = Executors.newFixedThreadPool(2);
        local = new InheritableThreadLocal<>();
        local.set("aaa");

        service.execute(()->{
            System.out.println(local.get());
        });
        local.set("bbb");
        service.execute(()->{
            System.out.println(local.get());
        });
        local.set("ccc");
        service.execute(()->{
            System.out.println(local.get());
        });
        local.set("ddd");
        service.execute(()->{
            System.out.println(local.get());
        });
        local.set("eee");
        service.execute(new RunTask());
        local.set("fff");
        service.execute(new RunTask(()->{
            System.out.println(local.get());
        }));
        local.set("ggg");
        service.execute(new RunTask(()->{
            System.out.println(local.get());
        }));
        local.set("hhh");
        service.execute(new RunTask());






    }


}


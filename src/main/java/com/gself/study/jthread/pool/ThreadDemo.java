package com.gself.study.jthread.pool;

/**
 * 定义线程
 * 休眠10S 输出线程号
 * Created by gtt on 2020/5/1.
 */
public class ThreadDemo extends Thread {
    int id ;
    public ThreadDemo(int id){
        this.id = id;
    }

    public synchronized static void print(String str){
        System.out.println(str);
    }

    public void run(){
        try{
            print(id+"");
            Thread.sleep(5*1000);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

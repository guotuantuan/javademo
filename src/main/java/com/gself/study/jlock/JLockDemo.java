package com.gself.study.jlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/7/30 11:07
 */
public class JLockDemo {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void conditionTest(){
        try {
            lock.lock();
            System.out.println("---");

            condition.await();
            System.out.println("123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void conditionTest2(){
        lock.lock();
        condition.signal();
        System.out.println("456");
        lock.unlock();
    }

    public static void main(String[] args) {
        JLockDemo demo = new JLockDemo();
        new Thread(()->{demo.conditionTest();}).start();
        new Thread(()->{demo.conditionTest2();}).start();

    }


}

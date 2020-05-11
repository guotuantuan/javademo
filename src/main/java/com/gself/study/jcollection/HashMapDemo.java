package com.gself.study.jcollection;

import sun.misc.Unsafe;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * HashMap演示类，线程同步
 * Created by gtt on 2020/5/2.
 */
public class HashMapDemo {

    /**
     * 普通hashmap线程不安全
     */
    static Map<Integer,Object> map = new HashMap<>(1);



    /**
     * hashtable线程安全
     */
//    static Map<Integer,Object> map = new Hashtable<>(1);

    /**
     * ConcurrentHashMap线程安全
     */
//    static Map<Integer,Object> map = new ConcurrentHashMap<>();

    /**
     * 使用collections.synchronizedMap方法使hashmap线程安全
     */
    public void synchronizedMap()throws Exception{
        Map<Integer,Object> res = new Hashtable<>();
        map = Collections.synchronizedMap(res);
        Thread t = new Thread(new MapThread());
        Thread t2 = new Thread(new MapThread2());
        Thread t3 = new Thread(new MapThread3());
        Thread t4 = new Thread(new MapThread4());
        Thread t5 = new Thread(new MapThread5());
        Thread t6 = new Thread(new MapThread6());
        Thread t7 = new Thread(new MapThread7());
        Thread t8 = new Thread(new MapThread8());
        t.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        Thread.sleep(5*1000);

        System.out.println(map.size());

    }


    /**
     * 查看ConcurrentHashMapput方法底层实现
     * @throws Exception
     */
    public void hashMapDebug()throws Exception{
        Map<Integer,Object> map = new ConcurrentHashMap<>(1);
        map.put(1,"abc");
        map.put(17,"abcd");
        map.put(33,"abcde");

    }

    /**
     * 查看unSafe提供CAS锁方法
     * @throws Exception
     */
    public void unSafeTest()throws Exception{
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        System.out.println(1);
    }

    /**
     * 演示hashmap线程不安全
     * @throws Exception
     */
    public void hashMap()throws Exception{
        Thread t = new Thread(new MapThread());
        Thread t2 = new Thread(new MapThread2());
        Thread t3 = new Thread(new MapThread3());
        Thread t4 = new Thread(new MapThread4());
        Thread t5 = new Thread(new MapThread5());
        Thread t6 = new Thread(new MapThread6());
        Thread t7 = new Thread(new MapThread7());
        Thread t8 = new Thread(new MapThread8());
        t.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        Thread.sleep(5*1000);

        System.out.println(map.size());

    }



    /**
     * 演示Reflection.getCallerClass()方法
     * Reflection.getCallerClass是获取方法调用者的类信息，但只能在java提供的包里使用，自定义的包不能使用，是根据类加载器能不能使用
     * @CallerSensitive注解是如果有这个注解则跳过这层调用者，直到找到没有这个注解的类
     * @throws Exception
     */
    @CallerSensitive
    public void reflection()throws Exception{
        Class c = Class.forName("com.gself.study.jcompare.ComparableDemo");
        ClassLoader c0 = this.getClass().getClassLoader().getParent();
        Class c1 = Reflection.getCallerClass(0);
        Class c2 = Reflection.getCallerClass(1);
        Class c3 = Reflection.getCallerClass(2);
        Class c4 = Reflection.getCallerClass(3);
        Class c5 = Reflection.getCallerClass(4);


        System.out.println(1);
    }




    class MapThread implements Runnable{
        @Override
        public void run() {
            for(int i=1;i<=10000;i++){
                map.put(i,i+"");
            }

        }
    }
    class MapThread2 implements Runnable{
        @Override
        public void run() {
            for(int i=10001;i<=20000;i++){
                map.put(i,i+"");
            }
        }
    }
    class MapThread3 implements Runnable{
        @Override
        public void run() {
            for(int i=30001;i<=40000;i++){
                map.put(i,i+"");
            }
        }
    }
    class MapThread4 implements Runnable{
        @Override
        public void run() {
            for(int i=40001;i<=50000;i++){
                map.put(i,i+"");
            }
        }
    }
    class MapThread5 implements Runnable{
        @Override
        public void run() {
            for(int i=50001;i<=60000;i++){
                map.put(i,i+"");
            }
        }
    }
    class MapThread6 implements Runnable{
        @Override
        public void run() {
            for(int i=60001;i<=70000;i++){
                map.put(i,i+"");
            }
        }
    }
    class MapThread7 implements Runnable{
        @Override
        public void run() {
            for(int i=70001;i<=80000;i++){
                map.put(i,i+"");
            }
        }
    }
    class MapThread8 implements Runnable{
        @Override
        public void run() {
            for(int i=80001;i<=90000;i++){
                map.put(i,i+"");
            }
        }
    }

}

package com.gself.study.jthread.InheribleDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by guotuantuan on 2020/10/20 20:10
 */
public abstract   class InheritableTask  implements Runnable {
    Object inheritableThreadLocals;
    private static volatile Field inheritableField;
    private static volatile Method inheritableMethod;
    private static volatile Class paramType;
    private static ReentrantLock fieldLock = new ReentrantLock();
    private static ReentrantLock methodLock = new ReentrantLock();
    private static ReentrantLock typeLock = new ReentrantLock();
    private InheritableInterface inheritableInterface;


    /**
     * 通过反射获取Thread类的inheritableThreadLocals的Field
     * @return
     */
    private static Field getInheritableField(){
        if(inheritableField != null){
            return inheritableField;
        }
        fieldLock.lock();
        if(inheritableField != null){
            return inheritableField;
        }
        try {
            inheritableField = Thread.class.getDeclaredField("inheritableThreadLocals");
            if(inheritableField != null){
                paramType = inheritableField.getType();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }finally {
            fieldLock.unlock();
        }
        return inheritableField;
    }

    /**
     * 通过反射获取ThreadLocal中获取ThreadLocalMap的Method
     * @return
     */
    private static Method getInheritableMethod(){
        if(inheritableMethod != null){
            return inheritableMethod;
        }
        methodLock.lock();
        if(inheritableMethod != null){
            return inheritableMethod;
        }
        try {
            if(paramType==null){
                getParamType();
            }
            inheritableMethod = ThreadLocal.class.getDeclaredMethod("createInheritedMap",paramType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }finally {
            methodLock.unlock();
        }
        return inheritableMethod;

    }

    /**
     * 获取ThreadLocal的Class
     * @return
     */
    private static Class getParamType(){
        if(paramType!=null){
            return paramType;
        }
        typeLock.lock();
        if(paramType!=null){
            return paramType;
        }
        try{
            if(inheritableField==null){
                getInheritableField();
            }
            paramType = inheritableField.getType();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            typeLock.unlock();
        }
        return paramType;

    }


    public InheritableTask(InheritableInterface inheritableInterface){
        init();
        this.inheritableInterface = inheritableInterface;
    }

    public InheritableTask(){
        init();
    }

    /**
     * ，
     * 初始化类时获取当前线程的inheritableThreadLocals值，缓存下来用于线程执行时加入到执行线程中
     */
    public  void init(){
        try{
            Thread thread = Thread.currentThread();
            Field field = getInheritableField();
            field.setAccessible(true);
            Object threadLocalValue = field.get(thread);
            if(threadLocalValue!=null){
                Method method = getInheritableMethod();
                method.setAccessible(true);
                Object parentValue = method.invoke(ThreadLocal.class, threadLocalValue);
                inheritableThreadLocals = parentValue;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    abstract void runTask();

    /**
     * 执行线程run方法时先将inheritableThreadLocals放入线程中
     */
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        Field field = getInheritableField();
        try{
            field.setAccessible(true);
            if(inheritableThreadLocals != null && field != null){
                field.set(thread,inheritableThreadLocals);
                inheritableThreadLocals = null;
            }
            if(inheritableInterface!=null){
                inheritableInterface.m();
            }else{
                runTask();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                field.set(thread,null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

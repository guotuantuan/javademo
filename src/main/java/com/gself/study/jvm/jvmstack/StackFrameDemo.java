package com.gself.study.jvm.jvmstack;

/**
 * Created by gtt on 2020/2/25.
 */
public class StackFrameDemo {
    public static void main(String[] args) {
        StackFrameDemo stackFrameDemo = new StackFrameDemo();
        stackFrameDemo.method1();
    }
    public void method1(){
        System.out.println("method1开始执行");
        method2();
        System.out.println("method1执行结束");
    }
    public int method2(){
        System.out.println("method2开始执行");
        int i = 10;
        int m = (int)method3();
        System.out.println("method2即将结束");
        return i+m;
    }
    public double method3(){
        System.out.println("method3开始执行");
        double j = 20.0;
        System.out.println("method3即将结束");
        return j;
    }

}

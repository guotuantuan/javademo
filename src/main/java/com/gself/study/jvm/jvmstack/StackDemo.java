package com.gself.study.jvm.jvmstack;

/**
 * Created by gtt on 2020/2/25.
 */
public class StackDemo {
    public static void main(String[] args) {
        StackDemo stackDemo = new StackDemo();
        stackDemo.methodA();
    }
    public void methodA(){
        int i = 10;
        int j = 20;
        methodB();
    }
    public void methodB(){
        int k = 30;
        int m = 40;
    }
}

package com.gself.study.jpattern.proxy;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 14:38
 */
public class JavaDeveloper implements Developer {
    @Override
    public void code() {
        System.out.println("java code...");
    }

    @Override
    public void debug() {
        System.out.println("java debug...");
    }
}

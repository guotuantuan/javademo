package com.gself.study.jvm.classLoaderProcess;

/**
 * Created by gtt on 2020/2/23.
 */
public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        System.out.println(1);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = systemClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        ClassLoader classLoaderDemo1 = ClassLoaderDemo1.class.getClassLoader();

    }
}

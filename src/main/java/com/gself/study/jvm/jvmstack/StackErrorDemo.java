package com.gself.study.jvm.jvmstack;

/**
 * Created by gtt on 2020/2/25.
 *
 * 默认是2014k  打印到11139
 * 设置栈大小
 * -Xss256k
 * 打印到  2453
 */
public class StackErrorDemo {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}

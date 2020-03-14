package com.gself.study.jvm.jvmstack;

import java.util.Date;

/**
 * Created by gtt on 2020/2/25.
 * 局部变量表
 */
public class LocalVariableDemo {
    public static void main(String[] args) {
        LocalVariableDemo variableDemo = new LocalVariableDemo();
        int num = 10;
        variableDemo.test1();
    }
    public void test1(){
        Date date = new Date();
        String name1 = "abcdefg.com";
        String info = test2(date,name1);
        System.out.println(date+name1);
    }
    public String test2(Date dateP,String name2){
        dateP =  null;
        name2 = "hijklmn";
        double weight = 130.5;
        char gender = '男';
        return dateP+name2;
    }
}

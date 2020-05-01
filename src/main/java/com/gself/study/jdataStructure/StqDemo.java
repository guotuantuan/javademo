package com.gself.study.jdataStructure;

import java.util.Stack;

/** 使用栈结构实现队列
 * Created by gtt on 2020/3/26.
 */
public class StqDemo {
    public static Stack<String> dataS = new Stack<>();
    public static Stack<String> helpS = new Stack<>();
    public static void add(String str){
        dataS.push(str);
    }
    public static String poll(){
        if(helpS.size()==0){
            while(dataS.size()>0){
                helpS.push(dataS.pop());
            }
        }
        return helpS.pop();
    }

    public static void main(String[] args) {
        StqDemo.add("a");
        StqDemo.add("b");
        System.out.println(StqDemo.poll());
        StqDemo.add("c");
        StqDemo.add("d");
        System.out.println(StqDemo.poll());
        StqDemo.add("e");
        StqDemo.add("f");
        System.out.println(StqDemo.poll());
        System.out.println(StqDemo.poll());
        System.out.println(StqDemo.poll());
        System.out.println(StqDemo.poll());
    }

}

package com.gself.study.jdataStructure;

import java.util.LinkedList;
import java.util.Queue;

/** 利用队列实现栈结构
 * Created by gtt on 2020/3/26.
 */
public class QTSDemo {
    public static Queue<String> dataQ= new LinkedList<>();
    public static Queue<String> helpQ = new LinkedList<>();

    public static void push(String s){
        dataQ.add(s);
    }
    public static String pop(){
        while(dataQ.size()>1){
            helpQ.add(dataQ.poll());
        }
        Queue t = dataQ;
        dataQ = helpQ;
        helpQ = t;
        return helpQ.poll();
    }
    public static void main(String[] args) {
        QTSDemo.push("a");
        QTSDemo.push("b");
        System.out.println(QTSDemo.pop());
        QTSDemo.push("c");
        QTSDemo.push("d");
        System.out.println(QTSDemo.pop());
        System.out.println(QTSDemo.pop());
        System.out.println(QTSDemo.pop());
        System.out.println(QTSDemo.pop());
    }
}

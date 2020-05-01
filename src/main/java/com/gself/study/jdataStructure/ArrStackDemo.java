package com.gself.study.jdataStructure;

/**
 *
 * 使用数组实现栈结构
 * Created by gtt on 2020/3/25.
 */
public class ArrStackDemo {
    public static int[]arr = new int[5];

    public static int end = -1;

    public static void push(int i){
        if(end==arr.length-1){
            System.out.println("enough");
            return;
        }

        arr[++end] = i;

    }
    public static int pop(){
        if(end<0){
            System.out.println("empty");
            return -1;
        }

        return arr[end--];
    }

    public static void main(String[] args) {
        ArrStackDemo.push(1);
        ArrStackDemo.push(2);
        System.out.println(ArrStackDemo.pop());
        ArrStackDemo.push(3);
        ArrStackDemo.push(4);
        ArrStackDemo.push(5);
//        ArrStackDemo.push(6);
        System.out.println(ArrStackDemo.pop());
        System.out.println(ArrStackDemo.pop());
        System.out.println(ArrStackDemo.pop());
        System.out.println(ArrStackDemo.pop());
        System.out.println(ArrStackDemo.pop());
        System.out.println(ArrStackDemo.pop());
        System.out.println(ArrStackDemo.pop());
    }
}

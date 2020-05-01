package com.gself.study.jdataStructure;

/**
 * 使用数组实现队列
 * Created by gtt on 2020/3/25.
 */
public class ArrQueueDemo {
    public static int []arr = new int[5];

    public static int  size = 0;
    public static int start = 0;
    public static int end = 0;
    public static void add(int i){
        if(size<arr.length){
            arr[(end++)%arr.length] = i;
            size++;
        }else{
            System.out.println("enough");
        }
    }
    public static int poll(){
        if(size>0){
            size--;
            return arr[(start++)%arr.length];

        }else{
            System.out.println("empty");
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrQueueDemo.add(1);
        ArrQueueDemo.add(2);
        ArrQueueDemo.poll();
        ArrQueueDemo.add(3);
        ArrQueueDemo.add(4);
        ArrQueueDemo.add(5);
        ArrQueueDemo.add(6);
        System.out.println(ArrQueueDemo.poll());
        System.out.println(ArrQueueDemo.poll());
        System.out.println(ArrQueueDemo.poll());
        System.out.println(ArrQueueDemo.poll());
        System.out.println(ArrQueueDemo.poll());
        System.out.println(ArrQueueDemo.poll());


    }

}

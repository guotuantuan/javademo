package com.gself.study.jtype;

import java.util.*;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/9 16:15
 */
public class CollectionDemo {


    /**
     * list转array
     */
    public void listToArray(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[]arr = new String[list.size()];
        list.toArray(arr);
        System.out.println(arr.length);
    }

    /**
     * array转list
     */
    public void arrayToList(){
        String[] arr = new String[3];
        arr[0]="a";
        arr[1]="b";
        arr[2]="c";
        List<String> list  = Arrays.asList(arr);
        System.out.println(list.size());

    }

    /**
     * 给list排序
     */
    public void sortList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1;
            }
        });
        System.out.println(1);
    }

    public void sortArray(){
        Integer[] arr = new Integer[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        Arrays.sort(arr,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1;
            }
        });
        System.out.println(1);
    }
}

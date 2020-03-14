package com.gself.study.jvm.jvmstack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by gtt on 2020/3/3.
 */
public class OperatedStackDemo {
    public void testAddOperation(){
        byte i = 15 ;
        int j = 8;
        int k = i+j;
    }

    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        set.add(2L);
        set.add(1L);
        Iterator iterator = set.iterator();
        System.out.println(set.size());
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

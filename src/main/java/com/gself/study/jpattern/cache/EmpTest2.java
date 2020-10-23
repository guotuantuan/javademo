package com.gself.study.jpattern.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by guotuantuan on 2020/10/23 18:15
 */
public class EmpTest2 {
    public static void main(String[] args) {
        ReferenceQueue<Employee> queue = new ReferenceQueue<>();
        Employee employee = new Employee("1");
        System.out.println(employee);
        WeakReference<Employee> weak = new WeakReference<>(employee,queue);
        System.out.println(weak.get().getId());
        System.out.println(weak);
        employee = null;
        System.out.println(weak.get());
        System.gc();
        System.out.println(weak.get());
        System.out.println("-----");
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WeakReference<Employee> poll = (WeakReference<Employee>) queue.poll();
            if(poll!=null){
                System.out.println(poll);
                System.out.println(poll.get());
            }
        }

    }
}

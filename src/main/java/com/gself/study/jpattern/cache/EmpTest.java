package com.gself.study.jpattern.cache;

/**
 * Created by guotuantuan on 2020/10/23 17:59
 */
public class EmpTest {

    public static void main(String[] args) {
        EmployeeCache employeeCache = new EmployeeCache();
        for(int i=0;i<10;i++){
            Employee e = employeeCache.getEmployee(i+"");
            System.out.println(e);
            Employee e2= employeeCache.getEmployee(i+"");
            System.out.println(e2);
        }
        System.gc();
        for(int i=0;i<10;i++){
            Employee e = employeeCache.getEmployee(i+"");
            System.out.println(e);

        }


    }
}

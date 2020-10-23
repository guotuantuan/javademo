package com.gself.study.jpattern.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * weakRefrence
 * Created by guotuantuan on 2020/10/23 17:39
 */
public class EmployeeCache  {

    private Map<String,WeakEmployee> refrent = new HashMap<>();

    private ReferenceQueue<Employee> queue = new ReferenceQueue<>();


    private class WeakEmployee extends WeakReference<Employee>{
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public WeakEmployee(Employee employee , ReferenceQueue<Employee> queue){
            super(employee,queue);
            this.key = employee.getId();
        }
    }

    public Employee getEmployee(String id){
        Employee e = null;
        if(refrent.containsKey(id)){
            e = refrent.get(id).get();
        }
        if(e==null){
            e = new Employee(id);
            cacheEmployee(e);
        }

        return e;

    }

    public void  cacheEmployee(Employee e){
        cleanCache();
        WeakEmployee employee = new WeakEmployee(e,queue);
        refrent.put(e.getId(),employee);
    }
    public void cleanCache(){
        WeakEmployee e = null;
        System.out.println("---");
        while( (e = (WeakEmployee) queue.poll())!=null){
            System.out.println("del....."+e.getKey());
            refrent.remove(e.getKey());

        }
    }
}

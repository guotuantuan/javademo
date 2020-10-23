package com.gself.study.jpattern.cache;

/**
 * Created by guotuantuan on 2020/10/23 17:37
 */
public class Employee {
    private String id;
    private String name;

    public Employee(String id){
        this.id = id;
        this.name = System.currentTimeMillis()+"";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

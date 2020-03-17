package com.gself.study.jpattern.factory.simpleFactory;

/**
 * Created by gtt on 2020/3/17.
 */
public abstract class Pizza {

    public String name;

    public void setName(String name){
        this.name = name;
    }

    abstract void prepare();

    public void bak(){
        System.out.println("baking...");
    }

    public void cut(){
        System.out.println("cuting...");
    }

    public void box(){
        System.out.println("boxing...");
    }

    public String toString(){
        return "name:"+name;
    }

}

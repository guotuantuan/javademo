package com.gself.study.jthread.InheribleDemo;

/**
 * Created by guotuantuan on 2020/10/20 20:36
 */
public class RunTask extends InheritableTask {


    public RunTask(){}


    public RunTask(InheritableInterface inheritableInterface){
        super(inheritableInterface);
    }

    @Override
    public void runTask() {

        System.out.println(InheriDemo.local.get());
    }
}

package com.gself.study.jExercise.xdf;

/**
 * Created by gtt on 2020/4/29.
 */
public class LastBoxValue {
    /**
     * 2、（程序题）有N个鸡蛋，要依次投放到如下盒子中（盒子数未知，直至全部放入为止），
     【1】，【2】，【4】，【8】，【16】。。。。【？】
     请问，已知n个鸡蛋，最后一个盒子有多少个鸡蛋
     * 获取最后一个盒子里的值  1,2,4,8,16,这样放下去，求一个数最后一个盒子里放的是几
     * @param num
     * @return
     */
    public int getLast (int num){
        if(num==1){
            return 1;
        }
        int a = 2;
        while(a<num){
            a*=2;
        }
        int pre = a/2-1;
        return num-pre;

    }

    public static void main(String[] args) {
        LastBoxValue m = new LastBoxValue();
        int res = m.getLast(5095);
        System.out.println(res);
    }
}

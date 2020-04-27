package com.gself.study.jpattern.share;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/27 16:42
 */
public class ConcreteFlyWeight implements Flyweight {

    private Character intrinsiccState = null;


    public ConcreteFlyWeight(Character intrinsiccState){
        this.intrinsiccState = intrinsiccState;
    }

    @Override
    public void operation(String state) {
        System.out.println("Intrinsic State = "+this.intrinsiccState);
        System.out.println("Extrinsic State = "+state);
    }
}

package com.gself.study.jpattern.share;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/27 17:02
 */
public class ShareClient {
    public void test(){
        FlyWeightFactory factory = new FlyWeightFactory();
        Flyweight fly = factory.factory(new Character('a'));
        fly.operation("first call");
        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");

        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");
    }
}

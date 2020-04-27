package com.gself.study.jpattern.share;

import java.util.ArrayList;
import java.util.List;

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

    public void test2(){
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('a');
        list.add('b');

        FlyWeightFactory factory = new FlyWeightFactory();
        Flyweight f1 = factory.factory(list);

        Flyweight f2 = factory.factory(list);
        f1.operation("Composite Call");
        System.out.println(f1==f2);
    }
}

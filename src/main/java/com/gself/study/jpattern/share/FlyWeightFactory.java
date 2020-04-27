package com.gself.study.jpattern.share;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/27 16:55
 */
public class FlyWeightFactory {
    private Map<Character,Flyweight> files = new HashMap<>();

    public Flyweight factory(Character state){
        Flyweight fly = files.get(state);
        if(fly==null){
            fly = new ConcreteFlyWeight(state);
            files.put(state,fly);
        }
        return  fly;
    }
}

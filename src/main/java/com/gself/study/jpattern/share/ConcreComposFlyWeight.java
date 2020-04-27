package com.gself.study.jpattern.share;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/27 17:32
 */
public class ConcreComposFlyWeight implements Flyweight {

    private Map<Character,Flyweight> files = new HashMap<>();

    public void add(Character c,Flyweight flyweight){
        files.put(c,flyweight);
    }

    @Override
    public void operation(String state) {
       Flyweight fly = null;
       for(Character c:files.keySet()){
           fly = files.get(c);
           fly.operation(state);

       }
    }
}

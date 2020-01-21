package com.gself.study.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 9:54
 */
public class TestDemo {



    @Test
    public void test01(){
        Map<String,Object> map = new HashMap<>();
        map.put("a","123");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("b","123");
        System.out.println(map.get("a")==map2.get("b"));
        System.out.println(map.get("a").equals(map2.get("b")));

    }
}

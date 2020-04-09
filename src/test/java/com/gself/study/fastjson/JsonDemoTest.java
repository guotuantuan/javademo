package com.gself.study.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 11:02
 */
public class JsonDemoTest {
    /**
     * 将对象转化为json字符串
     */
    @Test
    public void test01(){
        JsonDemo jd = new JsonDemo();
        Map<String,Object> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        System.out.println(jd.objToString(map));
    }

    /**
     * 将字符串转化为map
     */
    @Test
    public void test02(){
        JsonDemo jd = new JsonDemo();
        String str = "{\"a\":\"1\",\"b\":\"2\"}";
        Map map = new HashMap();
        map = jd.stringToObj(str,map);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }

    /**
     * 处理多层嵌套的json字符串转为JSONObject
     */
    @Test
    public void test03(){
        JsonDemo jd = new JsonDemo();
        String str = "{\"a\":\"1\",\"b\":\"2\"}";
        JSONObject jb = jd.stringToJsonObject(str);
        System.out.println(jb.get("a"));
    }

    /**
     * 将list转为json字符串会变成jsonArray形式
     */
    @Test
    public void test04(){
        JsonDemo jd = new JsonDemo();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String s = jd.listToString(list);
        List<String> list2 = new ArrayList<>();
        list2 = jd.stringToObj(s,list2);
        System.out.println(1);
    }
}

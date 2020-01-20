package com.gself.study.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
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
        System.out.println(jd.ObjToString(map));
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
}

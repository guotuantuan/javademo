package com.gself.study.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 11:00
 */
public class JsonDemo {
    /**
     * 对象转为json字符串
     * @param obj
     * @return
     */
    public String ObjToString(Object obj){
        return JSONObject.toJSONString(obj);
    }

    /**
     * 将json字符传转化为对象
     * @param str
     * @param t
     * @param <T>
     * @return
     */
    public <T> T stringToObj(String str,T t){
        return (T)JSONObject.parseObject(str,t.getClass());
    }

    /**
     * 好几层嵌套的类型要转化为JSONObject 再进行操作
     * @param str
     * @return
     */
    public JSONObject stringToJsonObject(String str){
        return JSONObject.parseObject(str);
    }
}

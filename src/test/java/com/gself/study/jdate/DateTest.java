package com.gself.study.jdate;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * @Author:gtt
 * @Description
 *
 * 测试java日期类型
 *
 *
 * @Date: 2020/1/20 10:16
 */

public class DateTest {
    /**
     * 获取上周的周一到周日时间
     *
     * @throws Exception
     */
    @Test
    public void test01()throws Exception{
        CalendarDemo cd = new CalendarDemo();
        Map map = cd.getWeek(-1,"2020-01-18 00:00:00");
        String str = JSONObject.toJSONString(map);
        System.out.println(str);
    }
}

package com.gself.study.jdate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/20 10:18
 */
public class CalendarDemo {
    /**
     * 获取上周的周一到周日时间               注意当前时间是周日获取问题
     * @param type
     * @param curDate
     * @return map
     */
    public Map getWeek(int type,String curDate)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Map<String,Object> res = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(curDate));
        if(calendar.get(Calendar.DAY_OF_WEEK)==1){
            calendar.add(Calendar.DAY_OF_WEEK,-1);
        }
        calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        calendar.add(Calendar.WEEK_OF_YEAR,type);
        res.put("beginDate",sdf.format(calendar.getTime()));
        calendar.add(Calendar.WEEK_OF_YEAR,1);
        res.put("endDate",sdf.format(calendar.getTime()));
        res.put("curDate",curDate);
        return res;
    }
}

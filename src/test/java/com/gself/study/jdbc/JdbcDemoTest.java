package com.gself.study.jdbc;

import org.junit.Test;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/21 10:56
 */
public class JdbcDemoTest {

    @Test
    public void test01()throws Exception{
        JdbcDemo jd = new JdbcDemo();
        jd.connect();
    }
}

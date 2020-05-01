package com.gself.study.jtype;

import org.junit.Test;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/9 10:56
 */
public class ByteDemoTest {

    @Test
    public void test01()throws Exception{
        ByteDemo byteDemo = new ByteDemo();
        byteDemo.charToByte('中');

    }

    @Test
    public void test02()throws Exception{
        ByteDemo byteDemo = new ByteDemo();
        byteDemo.mod();

    }

    @Test
    public void test03()throws Exception{
        ByteDemo byteDemo = new ByteDemo();
        byteDemo.hash();

    }

    @Test
    public void test04()throws Exception{
        ByteDemo byteDemo = new ByteDemo();
        byteDemo.string();

    }




}

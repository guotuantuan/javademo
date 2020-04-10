package com.gself.study.jio;

import org.junit.Test;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/4/7 17:26
 */
public class IoDemoTest {


    @Test
    public void test1()throws Exception{
        IoDemo id = new IoDemo();
        id.fileInputData("E:\\test\\test.txt");
    }

    @Test
    public void test2()throws Exception{
        IoDemo id = new IoDemo();
        id.fileReaderData("E:\\test\\test.txt");
    }

    @Test
    public void test3()throws Exception{
        IoDemo id = new IoDemo();
        id.fileBufferData("E:\\test\\test.txt");
    }

    @Test
    public void test4()throws Exception{
        IoDemo id = new IoDemo();
        id.fileNioData("E:\\test\\test.txt");
    }

    @Test
    public void test5()throws Exception{
        IoDemo id = new IoDemo();
        id.fileNioOut("E:\\test\\test.txt");
    }

    @Test
    public void test6()throws Exception{
        IoDemo id = new IoDemo();
        id.fileNioInChar("E:\\test\\test.txt");
    }


}

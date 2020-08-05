package com.gself.study.jdataStructure;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/7/23 17:35
 */
public class BloomFilterTest {
    private static final String path = "E:\\upload文档\\filter\\test.txt";

    public static void main(String[] args) throws Exception {
        File file = new File(path);
        FileOutputStream stream = new FileOutputStream(file,true);
        for(int i=30;i<40;i++){
            stream.write((i+"").getBytes());
        }
        stream.close();
    }
}

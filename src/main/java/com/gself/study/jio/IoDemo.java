package com.gself.study.jio;

import java.io.*;

/**
 * @Author:gtt
 * @Description 读取数据
 * @Date: 2020/4/7 17:13
 */
public class IoDemo {



    /**
     * inputStream读取数据方式（字节流）  读取中文会乱码，因为一个中文占2个字节，而inputStream一次读取一个字节
     * @param filePath
     * @throws Exception
     */
    public void fileInputData(String filePath)throws Exception{
        File file = new File(filePath);
        FileInputStream fileInp = new FileInputStream(file);
        int in = 0;
        while((in=fileInp.read())!=-1){
            System.out.println((char)in);
        }

    }

    /**
     * Reader方式读取数据（字符流）  不会有中文乱码问题，因为Reader是每次读取一个字符，中文也是一个字符
     * @param filePath
     * @throws Exception
     */
    public void fileReaderData(String filePath)throws Exception{
        File file = new File(filePath);
        FileInputStream fileInp = new FileInputStream(file);
        InputStreamReader isReader = new InputStreamReader(fileInp);
        BufferedReader bReader = new BufferedReader(isReader);
        int in = 0;
        while((in = isReader.read())!=-1){
            System.out.println((char)in);
        }

    }
}

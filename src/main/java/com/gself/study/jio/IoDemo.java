package com.gself.study.jio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

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
     * 带缓冲的字节流  但byte长度不够，刚好最后一个是中文时，最后一位会是乱码，可以用BufferedReader
     * @param filePath
     * @throws Exception
     */
    public void fileBufferData(String filePath)throws Exception{
        File file = new File(filePath);
        FileInputStream fileInp = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fileInp);
        byte[] bytes = new byte[8];
        int in = 0;
        StringBuffer sbf = new StringBuffer();
        while((in = bis.read(bytes))!=-1){
            sbf.append(new String(bytes,0,in));
        }
        System.out.println(sbf.toString());
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

    /**
     * nio读取数据方式  ByteBuffer如果指定大小刚好最后有中文，会出现乱码，可以用CharBuffer
     * @param filePath
     * @throws Exception
     */
    public void fileNioData(String filePath)throws Exception{
        File file = new File(filePath);
        FileInputStream fileInp = new FileInputStream(file);
        FileChannel fc = fileInp.getChannel();
        ByteBuffer bbuf = ByteBuffer.allocate(9);
        System.out.println(bbuf.limit());
        System.out.println(bbuf.capacity());
        System.out.println(bbuf.position());
        fc.read(bbuf);
        byte[] bytes = new byte[bbuf.position()];
        bbuf.flip();
        bbuf.get(bytes);
        System.out.println(new String(bytes));


        byte[] bytes2 = new byte[bytes.length];
        //bbuf切换读和写模式，用flip()或者用clear(),就可以往里写了
//        bbuf.flip();
        bbuf.clear();
        bbuf.put(bytes);
        bbuf.flip();
        bbuf.get(bytes2);
        System.out.println(new String(bytes2));

    }

    /**
     * Nio读取中文字符问题   发现中文占三个字节 （UTF-8）
     * @param filePath
     * @throws Exception
     */
    public void fileNioInChar(String filePath)throws Exception{
        File file = new File(filePath);
        FileInputStream fileInp = new FileInputStream(file);
        FileChannel fc = fileInp.getChannel();
        ByteBuffer bbuf = ByteBuffer.allocate(8);
        Charset c1 = Charset.forName("UTF-8");
        CharsetDecoder cd = c1.newDecoder();
        System.out.println(bbuf.limit());
        System.out.println(bbuf.capacity());
        System.out.println(bbuf.position());
        fc.read(bbuf);
        bbuf.flip();

        CharBuffer cbuf = CharBuffer.allocate(32);
        //读取ByteBuffer到CharBuffer中，如果最后是中文的半个字符，则留在bbuf中
        cd.decode(bbuf,cbuf,true);
        System.out.println(bbuf.position());
        System.out.println(bbuf.limit());
        //定义辅助字节数组，存储留在ByteBuffer中的后半个中文字符
        byte[] remain = new byte[bbuf.limit()-bbuf.position()];
        bbuf.get(remain,0,remain.length);
        //将ByteBuffer置为读取模式，即position指到0开始位置
        bbuf.flip();
        System.out.println(bbuf.position());
        System.out.println(bbuf.limit());
        System.out.println(cbuf.position());
        //将CharBuffer置为读取模式，即position指到0开始位置,输出内容
        cbuf.flip();
        System.out.println(cbuf.position());
        System.out.println(cbuf.toString());
        //将辅助字节数组的内容填充到ByteBuffer中
        bbuf.put(remain);
        System.out.println(bbuf.position());
        //从channel中继续读取剩余字节
        fc.read(bbuf);
        System.out.println(bbuf.position());
        //将ByteBuffer置为读取模式
        bbuf.flip();
//        cbuf.flip();

        System.out.println(cbuf.position());
        //将读取ByteBuffer到CharBuffer中
        cd.decode(bbuf,cbuf,true);
        System.out.println(cbuf.position());

        System.out.println(cbuf.toString());

    }


    /**
     * Nio写入数据方式
     * @param filePath
     * @throws Exception
     */
    public void  fileNioOut(String filePath)throws Exception{
        File file = new File(filePath);
        FileOutputStream fileOut = new FileOutputStream(file,true);
        FileChannel fc = fileOut.getChannel();
        ByteBuffer bbf = ByteBuffer.allocate(1024);
        bbf.put("abc中国".getBytes());
        bbf.flip();
        fc.write(bbf);
        fc.close();
    }


}

package com.gself.study.jnio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by guott on 2021/3/11 20:21
 */
public class JNioDemo {

    public static void main(String[] args) {
        JNioDemo nioDemo = new JNioDemo();
        nioDemo.test01();
    }

    public void test01(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("D:\\other\\data\\test.txt"));
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            channel.close();
            fileInputStream.close();
            byteBuffer.flip();
            byte[] bytes = new byte[byteBuffer.limit()];
            byteBuffer.get(bytes);
            System.out.println(new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

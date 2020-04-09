package com.gself.study.jbyte;

/**
 * @Author:gtt
 * @Description java用int的10进制作为处理16进制的中介
 *
 * java处理16进制  0x开头代表16进制，java用int表示，例如0xA 用int表示为10，都当做10进制处理
 * java用int表示16进制
 * 将16进制转成字符显示  Integer.toHexString(a)  其中a是16进制数的int值
 * 将字符转成16进制的int值  Integer.parseInt(s,16)  其中s值为'A'
 * @Date: 2020/4/9 9:07
 */
public class ShiLiuDemo {
    public void convertShiLiu(){
        int a = 0x1A;
        //java 用int表示16进制
        System.out.println(a);
        //java 用字符展示16进制
        String s = Integer.toHexString(a);
        //java 将字符转为16进制（用int表示）
        System.out.println(Integer.parseInt(s,16));
        //java格式化输出16进制
        System.out.printf("%x",a);
    }
}

package com.gself.study.jsecurity;

import java.security.MessageDigest;

/** 加密算法使用demo
 * Created by gtt on 2020/5/11.
 */
public class JSecretDemo {


    /**
     * md5加密算法
     * @throws Exception
     */
    public void md5()throws Exception{
        MessageDigest digest = MessageDigest.getInstance("MD5");
        String str = "hello , welcome to my demo";
        byte[] res  = digest.digest(str.getBytes());
        System.out.println(res.length);
        byte b = -2;
        System.out.println(b);
        int a = b;
        System.out.println(a);
        int c = Math.abs(b);
        System.out.println(c);
        System.out.println(c|0x80);
        System.out.println(Integer.toHexString(-1));
        System.out.println(bytes2hex(res));
        System.out.println(bytes2hex(res).length());
    }

    /**
     *  字节数字转16进制，如果是负数，则将符号位作为数值用到计算当中
     *  方式：
     *  1.先求绝对值
     *  2.绝对值和0x80或运算
     *  3.再和0xFF与运算
     * @param bytes
     * @return
     */
    public String bytes2hex(byte[] bytes){
        String str = "abc";
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<bytes.length;i++){
            byte b = bytes[i];
            boolean neg = false;
            if(b<0){
                neg=true;
            }
            int inte = Math.abs(b);
            if(neg){
                inte = inte| 0x80;
            }
            String temp = Integer.toHexString(inte);
            if(temp.length() ==1){
                builder.append(0);
            }
            builder.append(temp.toLowerCase());
        }
        return builder.toString();
    }

}

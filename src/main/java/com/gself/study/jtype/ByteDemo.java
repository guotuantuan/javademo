package com.gself.study.jtype;

/**
 * @Author:gtt
 * @Description java类型转换
 * @Date: 2020/4/9 10:53
 */
public class ByteDemo {

    /**
     * char转字节数组
     * @param a
     * @return
     */
    public void  charToByte(char a)throws Exception{
        byte[] bytes =  String.valueOf(a).getBytes("UTF-8");
        System.out.println((int)bytes[0]);
    }

    /**
     * byte数组转String
     * @param bytes
     * @return
     * @throws Exception
     */
    public void byteToString(byte[] bytes) throws Exception{
        String str =  new String(bytes,"UTF-8");
        System.out.println(str);
    }
}

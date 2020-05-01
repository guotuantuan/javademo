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
        System.out.println(Character.SIZE);
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



    /**
     * 取余运算
     */
    public void mod(){
        System.out.println(4%12);
        System.out.println(-7%3);
        System.out.println(-2%12);
        System.out.println(-14%12);
        System.out.println(10%12);
        System.out.println(13%12);
        System.out.println(-1%127);
        int i  = -1;
        System.out.println(i);
    }

    /**
     * hashcode方法
     */
    public void hash(){
        String str = "abc";
        int hashCode = str.hashCode();
        System.out.println(hashCode);

        System.out.println(new ByteDemo().hashCode());
        int a = 2147483647;
        int b = a+1;
        System.out.println(b);
        int c = a+3;
        System.out.println(c);
        int d = a+2;
        System.out.println(d);
        int e = d&Integer.MAX_VALUE;
        System.out.println(e);
    }

    /**
     *string方法测试
     */

    public void string(){
        String str= "abc";
        str +="cd";
        System.out.println(str);

        String s1 = "abc"+"de";
        String s2 = "abcde";
        System.out.println(s1==s2);

        String s3 = "abc"+getStr();
        System.out.println(s2==s3);
        String s4 = "abc";
        String s5 = "de";
        String s6 = s4+s5;
        System.out.println(s2==s6);
        String s7 = "abc"+s5;
        System.out.println(s2==s7);

        String s8 = new String("abcde");
        System.out.println(s2==s8);

        String s9 = new String("abcde");
        System.out.println(s8==s9);

        String s10 = new String("xyz").intern();
        String s11 = new String("xyz").intern();
        System.out.println(s10==s11);
        s10+="uvw";
        System.out.println(s10);
        System.out.println(s11);



    }
    public String getStr(){
        return "de";
    }




}

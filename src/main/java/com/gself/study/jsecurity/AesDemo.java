package com.gself.study.jsecurity;


import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlBlockStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.misc.Unsafe;

import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by guotuantuan on 2020/10/22 11:44
 */


public class AesDemo {


    public static void main(String[] args) throws Exception {
        String content = "{\n" +
                "\t\"page\": 1,\n" +
                "\t\"pageSize\": 10,\n" +
                "\t\"skip\": 0\n" +
                "}";        // 原文内容

        String content2 = "id=5fce144f409c3636ccbe89e4#%name=张三";        // 原文内容
        String key = "123456";                  // AES加密/解密用的原始密码

        // 加密数据, 返回密文
        byte[] cipherBytes = encrypt(content2.getBytes(), key.getBytes());

        String res = parseByte2HexStr(cipherBytes);
        System.out.println(res);



        // 解密数据, 返回明文
        byte[] plainBytes = decrypt(parseHexStr2Byte(res), key.getBytes());




        // 输出解密后的明文: "Hello world!"
        System.out.println(new String(plainBytes));
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }




    /**
     * 生成密钥对象
     */
    private static SecretKey generateKey(byte[] key) throws Exception {
        // 根据指定的 RNG 算法, 创建安全随机数生成器
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        // 设置 密钥key的字节数组 作为安全随机数生成器的种子
        random.setSeed(key);

        // 创建 AES算法生成器
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        // 初始化算法生成器
        gen.init(128, random);

        // 生成 AES密钥对象, 也可以直接创建密钥对象: return new SecretKeySpec(key, ALGORITHM);
        return gen.generateKey();
    }

    /**
     * 数据加密: 明文 -> 密文
     */
    public static byte[] encrypt(byte[] plainBytes, byte[] key) throws Exception {
        // 生成密钥对象
        SecretKey secKey = generateKey(key);

        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化密码器（加密模型）
        cipher.init(Cipher.ENCRYPT_MODE, secKey);

        // 加密数据, 返回密文
        return cipher.doFinal(plainBytes);
    }

    /**
     * 数据解密: 密文 -> 明文
     */
    public static byte[] decrypt(byte[] cipherBytes, byte[] key) throws Exception {
        // 生成密钥对象
        SecretKey secKey = generateKey(key);

        // 获取 AES 密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化密码器（解密模型）
        cipher.init(Cipher.DECRYPT_MODE, secKey);

        // 解密数据, 返回明文
        return cipher.doFinal(cipherBytes);
    }


}

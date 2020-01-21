package com.gself.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/21 10:40
 */
public class JdbcDemo {
    public void connect()throws Exception{

        //将类加载到虚拟机中
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://172.18.10.226:3306/wemedia?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true";

        //返回连接
        Connection cnn = DriverManager.getConnection(url,"wemedia","wemedia2019!!");

        //创建执行sql的statement
        Statement stat = cnn.createStatement();

        //执行语句
        String sql = "select * from sys_account_dy where id = '9962328815'";

//        System.out.println(stat.execute(sql));
        ResultSet res = stat.executeQuery(sql);

        //输出查询结果
        while(res.next()){

            String nickName =  res.getString("nickName");

            System.out.println(nickName);
        }

        //关闭连接
        stat.close();

        cnn.close();


    }
}

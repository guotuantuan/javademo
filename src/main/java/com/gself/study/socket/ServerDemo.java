package com.gself.study.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/21 14:59
 */
public class ServerDemo {

    public void server()throws Exception{

        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("server========  start ");

        Socket socket = serverSocket.accept();

        //获取客户端连接信息
        System.out.println("server======== client:"+socket.getInetAddress());

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //读取客户端发送的信息
        String message = br.readLine();

        System.out.println("server======== accept message:"+message);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //反馈给client 注意要加\n（换行符）
        bw.write("server========server accept message\n");

        bw.flush();


    }
}

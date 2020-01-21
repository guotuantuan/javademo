package com.gself.study.socket;

import java.io.*;
import java.net.Socket;

/**
 * @Author:gtt
 * @Description  socket 通信demo
 * @Date: 2020/1/21 15:14
 */
public class ClientDemo {

    public void client() throws IOException {

        Socket socket = new Socket("127.0.0.1",8888);

        System.out.println("client======== client start");

        //构建IO
        OutputStream out = socket.getOutputStream();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        //向服务器发送消息   注意要加\n（换行符）
        bw.write("client======== hello this is a message from client\n ");

        bw.flush();

        //读取服务器返回消息

        InputStream in = socket.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String message = br.readLine();

        System.out.println("client======== accept message:"+message);
    }
}

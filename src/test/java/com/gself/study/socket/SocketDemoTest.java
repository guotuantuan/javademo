package com.gself.study.socket;

import org.junit.Test;

import java.io.IOException;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/1/21 15:20
 */
public class SocketDemoTest {

    @Test
    public void test01() throws Exception {
        ServerDemo serverDemo = new ServerDemo();
        serverDemo.server();
    }

    @Test
    public void test02() throws IOException {
        ClientDemo cd = new ClientDemo();
        cd.client();
    }
}

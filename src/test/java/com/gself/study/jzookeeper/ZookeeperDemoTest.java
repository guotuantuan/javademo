package com.gself.study.jzookeeper;

import org.junit.Test;

/**
 * Created by gtt on 2020/3/15.
 */
public class ZookeeperDemoTest {

    @Test
    public void testzk()throws Exception{
        ZookeeperDemo zkDemo = new ZookeeperDemo();
        zkDemo.createNode();
    }

    @Test
    public void testzkChildren()throws Exception{
        ZookeeperDemo zkDemo = new ZookeeperDemo();
        zkDemo.getDataAndWatch();
    }

    @Test
    public void testzkExist()throws Exception{
        ZookeeperDemo zkDemo = new ZookeeperDemo();
        zkDemo.exist();
    }
}

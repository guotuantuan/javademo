package com.gself.study.jzookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Created by gtt on 2020/3/15.
 */
public class ZookeeperDemo {
    private String connectString = "192.168.160.144:2181,192.168.160.145:2181,192.168.160.129:2181";

    int sessionTimeOut = 2000;

    private ZooKeeper zkClient;
    public ZookeeperDemo(){
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
                public void process(WatchedEvent watchedEvent) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 创建节点
     * @throws Exception
     */
    public void createNode()throws Exception{
        String path = zkClient.create("/zkClientTest","zkClientTest".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    /**
     * 获取节点信息
     * @throws Exception
     */
    public void getDataAndWatch() throws Exception{
        List<String> children = zkClient.getChildren("/",false);

        children.forEach(System.out::println);
    }

    /**
     * 判断节点是否存在
     * @throws Exception
     */
    public void exist() throws Exception{
        Stat stat = zkClient.exists("/zkClientTest",false);
        System.out.println(stat);
    }




}

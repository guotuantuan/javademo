package com.gself.study.jzookeeper;

import org.apache.zookeeper.*;

/**
 * Created by gtt on 2020/3/15.
 */
public class DistributeServer {

    private String connectString = "192.168.160.144:2181,192.168.160.145:2181,192.168.160.129:2181";

    int sessionTimeOut = 2000;

    ZooKeeper zkClient;
    public DistributeServer(){
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void register(String hostname){
        try{
            String path = zkClient.create("/servers/server"+hostname,hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("server up:"+path);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void business(){
        try{
            Thread.sleep(Long.MAX_VALUE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        DistributeServer dbServer = new DistributeServer();
        dbServer.register(args[0]);
        dbServer.business();
    }
}

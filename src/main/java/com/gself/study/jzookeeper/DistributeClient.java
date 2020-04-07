package com.gself.study.jzookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * Created by gtt on 2020/3/15.
 */
public class DistributeClient {

    private String connectString = "192.168.160.144:2181,192.168.160.145:2181,192.168.160.129:2181";

    int sessionTimeOut = 2000;

    ZooKeeper zkClient;
    public DistributeClient(){
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getPath());
                    System.out.println(watchedEvent.toString());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getChlidren(){
        try{
            List<String> list = zkClient.getChildren("/servers",true);
            list.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void getData(){
        try{
            byte[] bytes = zkClient.getData("/servers",true,null);
            System.out.println(new String(bytes));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void business(){
        try {
            Thread.sleep(Long.MAX_VALUE);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DistributeClient dbclient = new DistributeClient();
        dbclient.getChlidren();
        dbclient.getData();
        dbclient.business();


    }
}

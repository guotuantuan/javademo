package com.gself.study.jdataStructure;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Date;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/7/23 14:16
 */
public class BloomFilterDemo {
    Logger log = LoggerFactory.getLogger(BloomFilterDemo.class);

    private static final String mPath = "E:\\upload文档\\filter\\mfilter.txt";
    private static final String sPath = "E:\\upload文档\\filter\\sfilter.txt";

    int size = 10000000;   //1亿100000000

    long mnum = 0l;  //主过滤器数据个数
    long snum = 0l;  //从过滤器数据个数

    int p = 0;  //主过滤器位置

    long q = 10;  //持久化数据
    long index = 0;

    public String toString(){
        return "size:"+size+" mnum:"+mnum+" snum:"+snum+"  p:"+p+" q:"+q+" index:"+index;
    }

    BloomFilter<CharSequence>[] filters = new BloomFilter[2];

    public BloomFilterDemo(){
        //初始化数组
        filters[0] = initBloom(mPath);
        filters[1] = initBloom(sPath);
        mnum = filters[0].approximateElementCount();
        snum = filters[1].approximateElementCount();


    }

    /**
     * 初始化布隆过滤器
     * 1.先从本地读取
     * 2.本地没有，则生成新的过滤器
     * @return
     */
    public BloomFilter<CharSequence> initBloom(String path){
        BloomFilter<CharSequence> filter = getBloomFromTxt(path);
        if(null!=filter){
            return filter;
        }
        filter = createBloom();
        return filter;
    }

    /**
     * 将布隆过滤器持久化到本地
     * @param path1
     * @param path2
     */
    public void putBloomToTxt(String path1,String path2){
        OutputStream out1 = null;
        OutputStream out2 = null;
        try{
            File file1 = new File(path1);
            if(!file1.exists()){
                file1.createNewFile();
            }else{
                file1.delete();
                file1.createNewFile();

            }

            out1= new FileOutputStream(file1,false);
            filters[p].writeTo(out1);

            File file2 = new File(path2);
            if(!file2.exists()){
                file2.createNewFile();
            }else{
                file2.delete();
                file2.createNewFile();
            }
            out2 = new FileOutputStream(file2,false);
            filters[getPos(p)].writeTo(out2);

        }catch (Exception e){
            log.error("持久化过滤器到本地报错：",e);
        }finally {
            try {
                out1.close();
                out2.close();
            } catch (IOException e) {
                log.error("持久化过滤器关闭连接报错：",e);
            }
        }
    }

    /**
     * 从本地读取布隆过滤器信息
     * @param path
     * @return
     */
    public BloomFilter<CharSequence> getBloomFromTxt(String path){
        BloomFilter<CharSequence> filter = null;
        InputStream inputStream = null;
        try{
            File file = new File(path);
            if(!file.exists()){
                return null;
            }
            inputStream = new FileInputStream(file);
            filter = BloomFilter.readFrom(inputStream, Funnels.stringFunnel(Charset.forName("utf-8")));
        }catch (Exception e){
            log.error("从本地读取filer数据报错：",e);
        }finally {
            try {
                if(null!=inputStream){
                    inputStream.close();
                }

            } catch (IOException e) {
                log.error("从本地读取filer关闭连接报错：",e);
            }
        }
        return filter;
    }

    /**
     * 容量超过设置总量时，切换主副过滤器
     */
    public synchronized void convert(){
        if(!compare(mnum,size)){
            return;
        }
        int tep = p;
        //将副过滤器设置为主过滤器
        p = getPos(p);
        //重置副过滤器
        filters[tep] = createBloom();
        mnum= snum;
        snum = 0l;
    }



    /**
     * 比较两个数大小
     * @param x
     * @param y
     * @return
     */
    public boolean compare(long x, long y){
        return x>=y;
    }

    public boolean compareN(long x,long y){
        return x>y;
    }

    /**
     * 将url 放入两个过滤器 （AFilter ,BFilter）
     *
     * 如果AFilter数量超过总量一半，则同时向BFilter中存入数据
     * @param url
     * @return
     */
    public synchronized void put(String url){

        //设置主过滤器
        convert();
        if(filters[p].mightContain(url)){
            return;
        }
        filters[p].put(url);
        mnum++;

        if(compareN(mnum,size/2l)){
            int t = getPos(p);
            if(null==filters[t]){
                filters[t] = createBloom();
            }
            filters[t].put(url);
            snum++;
        }
        System.out.println("index:"+index);
        if(++index>q){
            System.out.println("=========开始持久化");
            long start = System.currentTimeMillis();
            new Thread(new PersistenceInner()).start();
//            putBloomToTxt(mPath,sPath);
            long end = System.currentTimeMillis();
            System.out.println("=========持久化耗时：{}"+(end-start));

            index = 0l;
        }

    }

    public int getPos(int i){
        return (i+1)%2;
    }

    /**
     * 生成过滤器
     * @return
     */
    public BloomFilter createBloom(){

        return BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),size,0.001F);
    }

    /**
     * 判断url是否已存在
     * @param url
     */
    public synchronized boolean isExist(String url){
        //设置主过滤器
        convert();
        boolean res = filters[p].mightContain(url);
        log.info("========url重复检测，url：{},res:{}",url,res);
        return res;
    }

    class PersistenceInner implements Runnable{
        @Override
        public void run() {
            putBloomToTxt(mPath,sPath);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilterDemo demo = new BloomFilterDemo();
        long end = System.currentTimeMillis();
        System.out.println("读取耗时："+(end-start));
        for(int i=1;i<=11;i++){
            String url = i+"";
            System.out.println("放入之前："+demo.isExist(url));
            demo.put(url);
            System.out.println(demo);
            System.out.println("放入之后："+demo.isExist(url));
        }
        for(int i=1;i<=11;i++){
            String url = i+"";
            System.out.println("测试数据"+i+"："+demo.isExist(url));
        }
        for(int i=50;i<=55;i++){
            String url = i+"";
            System.out.println("放入之前："+demo.isExist(url));
            demo.put(url);
            System.out.println(demo);
            System.out.println("放入之后："+demo.isExist(url));
        }

        for(int i=50;i<=55;i++){
            String url = i+"";
            System.out.println("测试数据"+i+"："+demo.isExist(url));
        }

    }
}

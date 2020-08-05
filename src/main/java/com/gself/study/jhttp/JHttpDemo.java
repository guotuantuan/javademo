package com.gself.study.jhttp;

import com.alibaba.fastjson.JSONObject;
import jdk.internal.util.xml.impl.Input;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author:gtt
 * @Description
 * @Date: 2020/8/4 16:12
 */
public class JHttpDemo {
    private static String url = "http://10.121.17.14:10188/newshottopic/hotTopic/carHotTopic?userToken=1q2w3e4r5t";
    public static void main(String[] args) {
        JHttpDemo demo = new JHttpDemo();
        demo.test();
    }
    public void test(){
        HttpPost post = new HttpPost(url);
        CloseableHttpClient client = HttpClientBuilder.create().build();



        JSONObject object = new JSONObject();
        object.put("taskData","111");
        try{
            StringEntity entity = new StringEntity(object.toString());
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");

            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json;charset=UTF-8");
            HttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
            InputStream input = response.getEntity().getContent();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader breader = new BufferedReader(reader);
            String message ;
            while((message=breader.readLine())!=null){
                System.out.println(message);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("结束");
    }
}

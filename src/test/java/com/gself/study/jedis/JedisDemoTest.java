package com.gself.study.jedis;

import org.junit.Test;

/**
 * Created by gtt on 2020/3/14.
 */
public class JedisDemoTest {

    @Test
    public void testConnect(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.testConnect();
    }

    @Test
    public void testMethodKey(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodKey();
    }

    @Test
    public void testMethodString(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodString();
    }

    @Test
    public void testMethodList(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodString();
    }

    @Test
    public void testMethodSet(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodSet();
    }

    @Test
    public void testMethodHash(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodHash();
    }

    @Test
    public void testMethodZset(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodZset();
    }

    @Test
    public void testMethodMulti(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodMulti();
    }

    @Test
    public void testMethodWatch(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodWatch();
    }

    @Test
    public void testMethodJedisPool(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.methodJedisPool();
    }

    @Test
    public void testLock(){
        JedisDemo jedisDemo = new JedisDemo();
        jedisDemo.testLock();
    }

}

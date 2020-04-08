package com.gself.study.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.*;

/**
 * Created by gtt on 2020/3/14.
 */



public class JedisDemo {



    /**
     * 测试redis联通性
     */
    public void testConnect(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        System.out.println(jedis.ping());

    }

    public void  methodKey(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        Set<String> set = jedis.keys("*");

        Iterator ite = set.iterator();
        while(ite.hasNext()){
            String key = ite.next().toString();
            System.out.println(key);
        }

        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.ttl("k1"));

    }

    /**
     * String类型
     */
    public void methodString(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        System.out.println(jedis.get("k1"));

        jedis.set("k2","v2");
        System.out.println(jedis.get("k2"));

        jedis.mset("k3","v3","k4","v4","k5","k6");
        List<String> list = jedis.mget("k3","k4","k5");
        list.forEach(System.out::println);
    }

    /**
     * list类型
     */

    public void methodList(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        jedis.lpush("mylist","v1","v2","v3","v4","v5");
        List<String> list = jedis.lrange("mylist",0,-1);
        list.forEach(System.out::println);
    }

    /**
     * set类型
     */

    public void methodSet(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        jedis.sadd("order","jd001");
        jedis.sadd("order","jd002");
        jedis.sadd("order","jd003");
        Set<String> set1 = jedis.smembers("order");
        Iterator ite = set1.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }

    /**
     * hash类型
     */

    public void methodHash(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        jedis.hset("hash1","userName","lisi");
        Map<String,String> map = new HashMap<>();
        map.put("telphone","11111111111");
        map.put("address","北京");
        jedis.hmset("hash2",map);
        List<String> list = jedis.hmget("hash2","telphone","address");
        list.forEach(System.out::println);
    }

    /**
     * zset类型
     */
    public void methodZset(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        jedis.zadd("zset01",60d,"v1");
        jedis.zadd("zset01",70d,"v2");
        jedis.zadd("zset01",80d,"v3");
        jedis.zadd("zset01",90d,"v4");

        Set<String> s1 = jedis.zrange("zset01",0,-1);
        Iterator ite = s1.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }
    }

    /**
     * 事务
     */
    public void methodMulti(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        Transaction transaction  = jedis.multi();

        transaction.set("tk4","tv4");
        transaction.set("tk5","tv5");
        transaction.exec();
        System.out.println(jedis.get("tk4"));
    }

    /**
     * watch监控
     */

    public void methodWatch(){
        Jedis jedis = new Jedis("39.105.141.113",6379);
        int balance = 100;
        jedis.set("balance",balance+"");
        jedis.watch("balance");
        jedis.incr("balance");  //为了演示watch  故意加上
        Transaction transaction = jedis.multi();
        transaction.incr("balance");
        transaction.exec();
        System.out.println(jedis.get("balance"));
    }

    /**
     * jedisPool测试
     */
    public void methodJedisPool(){
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            jedis.set("poolk1","poolv1");
            System.out.println(jedis.get("poolk1"));
        }catch (Exception e){

        }finally {
            JedisPoolUtil.release(jedisPool,jedis);
        }

    }

    public void testLock(){
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            boolean lock = tryGetDistributeLock(jedis,"lockKey","abc",600000);
            if(lock){
                System.out.println("获取锁");
                boolean lockRelease = releaseDistributedLock(jedis,"lockKey","abc");
                System.out.println(lockRelease);
            }else{
                System.out.println("未获得锁");
            }
        }catch (Exception e){

        }finally {
            JedisPoolUtil.release(jedisPool,jedis);
        }
    }

    /**
     * 获取redis分布式锁   其中PX为毫秒  EX为秒
     * @param jedis
     * @param lockKey
     * @param uniqueId
     * @param expireTime
     * @return
     */
    public boolean tryGetDistributeLock(Jedis jedis,String lockKey,String uniqueId,int expireTime){
        String result = jedis.set(lockKey,uniqueId,"NX","PX",expireTime);
        if(result.equals("OK")){
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param jedis
     * @param lockKey
     * @param uniqueId
     * @return
     */
    public boolean releaseDistributedLock(Jedis jedis,String lockKey,String uniqueId){
        String script = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object result = jedis.eval(script,Collections.singletonList(lockKey),Collections.singletonList(uniqueId));
        if(result.equals(1L)){
            return true;
        }
        return false;
    }






}

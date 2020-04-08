package com.gself.study.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by gtt on 2020/3/15.
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil(){

    }

    public static JedisPool getJedisPoolInstance(){
        if(null==jedisPool){
            synchronized (JedisPoolUtil.class){
                if(null==jedisPool){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

                    jedisPool = new JedisPool(jedisPoolConfig,"39.105.141.113",6379);
                }
            }
        }
        return jedisPool;
    }

    public static void release(JedisPool jedisPool, Jedis jedis){
        if(null!=jedis){
            jedisPool.returnResourceObject(jedis);
        }
    }
}

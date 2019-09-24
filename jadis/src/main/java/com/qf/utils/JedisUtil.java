package com.qf.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    //jedis连接池
    private static JedisPool jedisPool = null;
    static {
        //连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //最多与多少个jedis对象
        config.setMaxTotal(50);
        //最多有多少空闲的jedis对象
        config.setMaxTotal(20);
        //最大等待时间
        config.setMaxWaitMillis(5000);
        //检查连接的有效性
        config.setTestOnBorrow(true);
        config.setMinIdle(5);
        config.setMaxIdle(10);
        //创建连接池对象
        jedisPool = new JedisPool(config,"10.8.152.37",6379,1000,"0928");
    }
    //获取jedis对象
    public static Jedis getJedis(){
        Jedis resource = jedisPool.getResource();
        return resource;
    }


    public static void closeJedis(Jedis jedis){
        jedis.close();
    }
}

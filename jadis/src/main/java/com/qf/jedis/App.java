package com.qf.jedis;

import com.qf.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        //创建Jedis对象
//        Jedis jedis = new Jedis("10.8.152.37", 6379, 1000);
//        //设置redis服务的密码
//        jedis.auth("0928");
        //根据key值获取字符串获取值
//        String name = jedis.get("name");
//        System.out.println(name);
        //设置值
//        jedis.set("weight","100");
//        String weight = jedis.get("weight");
//        System.out.println(weight);
//        jedis.hset("person","name","zhangsan");
//        jedis.hset("person","name","lisi");
//
//        jedis.close();

        Jedis jedis1 = JedisUtil.getJedis();

        System.out.println(jedis1.get("name"));

        JedisUtil.closeJedis(jedis1);
    }
}

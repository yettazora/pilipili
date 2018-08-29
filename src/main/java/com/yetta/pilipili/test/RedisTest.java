package com.yetta.pilipili.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {


    private static final JedisPool POOL;

    static {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);
        POOL=new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
    }

    public static Jedis getJedis(){
        return POOL.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
//        jedis.set("name", "zsan");
        System.out.println(jedis.hkeys("key3"));//set<String>
        System.out.println(jedis.hvals("key3"));//list<String>
        System.out.println(jedis.keys("*"));//set<String>
        System.out.println(jedis.hmget("key3","name","city"));//list<String>
        System.out.println(jedis.hgetAll("key3"));//map<String,String>
        jedis.close();

        JedisPoolConfig poolConfig=new JedisPoolConfig();

        poolConfig.setMaxIdle(10);//空闲时最大连接数

        poolConfig.setMaxTotal(50);//最大连接数

        JedisPool pool=new JedisPool(poolConfig,"127.0.0.1",6379);

        Jedis jedis1=pool.getResource();

        System.out.println(jedis1.hgetAll("key3"));

        jedis1.close();
    }



}

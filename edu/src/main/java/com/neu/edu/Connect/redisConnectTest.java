package com.neu.edu.Connect;

import redis.clients.jedis.Jedis;

public class redisConnectTest {

    public static final int REDIS_PORT = 6379;

    public static final String LOCAL_HOST = "127.0.0.1";

    public static void main(String[] args) {
        Jedis jedis = new Jedis(LOCAL_HOST, REDIS_PORT);
        System.out.println(jedis.ping());

        jedis.lpush("site-list", "222","Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");

        jedis.set(Thread.currentThread().getName(),"JUST Test");

    }

}

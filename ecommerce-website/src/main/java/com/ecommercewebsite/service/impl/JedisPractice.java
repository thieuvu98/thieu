package com.ecommercewebsite.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisPractice {
    @Autowired
    private JedisPool jedisPool;

    public void test() {
        try (Jedis jedis = jedisPool.getResource()) {
//            jedis.set("name", "ThieuDz");

            System.out.println(jedis.get("name"));
        }
    }
}

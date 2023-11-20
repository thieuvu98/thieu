package com.ecommercewebsite.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration

public class AppConfiguration {
    @Value("${app.redis.host}")
    private String host;
    @Value("${app.redis.port}")
    private int port;
    @Value("${app.redis.password}")
    private String password;
    @Value("${app.redis.db-default}")
    private int db;
    @Value("${app.redis.timeout}")
    private int timeout;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JedisPool create() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(30);
        poolConfig.setMaxIdle(30);
        if (!StringUtils.hasText(password)) {
            password = null;
        }
        return new JedisPool(poolConfig, host, port, timeout, password, db);
    }
}

package com.hideyoshi.redispractice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository extends RedisAccessor {
    @Autowired
    public RedisRepository(RedisConnectionFactory connectionFactory) {
        setConnectionFactory(connectionFactory);
    }
}

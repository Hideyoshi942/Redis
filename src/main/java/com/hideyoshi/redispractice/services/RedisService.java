package com.hideyoshi.redispractice.services;

import com.hideyoshi.redispractice.entity.dto.RedisStringRequest;
import com.hideyoshi.redispractice.entity.dto.RedisStringResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RedisService {

    RedisTemplate<String, String> redisTemplate;

    public RedisStringResponse setValue(RedisStringRequest request) {
        redisTemplate.opsForValue().set(request.getKey(), request.getValue());
        return RedisStringResponse.builder()
                .key(request.getKey())
                .build();
    }

    public RedisStringResponse getValue(RedisStringRequest key) {
        var keyResponse = redisTemplate.opsForValue().get(key.getKey());
        return RedisStringResponse.builder()
                .key(Optional.ofNullable(keyResponse).map(Object::toString).orElse(null))
                .build();
    }

    public boolean deleteKey(RedisStringRequest key) {
        return redisTemplate.delete(key.getKey());
    }
}

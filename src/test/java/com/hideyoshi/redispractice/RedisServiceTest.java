package com.hideyoshi.redispractice;

import com.hideyoshi.redispractice.entity.dto.RedisStringRequest;
import com.hideyoshi.redispractice.entity.dto.RedisStringResponse;
import com.hideyoshi.redispractice.services.RedisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RedisServiceTest {
    @Mock
    private RedisTemplate<String, String> redisTemplate;
    @Mock
    private ValueOperations<String, String> valueOperations;
    @InjectMocks
    private RedisService redisService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    void testSetValue() {
        RedisStringRequest request = new RedisStringRequest();
        request.setKey("testKey");
        request.setValue("testValue");
        RedisStringResponse response = redisService.setValue(request);
        verify(valueOperations).set("testKey", "testValue");
        assertEquals("testKey", response.getKey());
    }

    @Test
    void testGetValue() {
        RedisStringRequest request = new RedisStringRequest();
        request.setKey("testKey");
        when(valueOperations.get("testKey")).thenReturn("testValue");
        RedisStringResponse response = redisService.getValue(request);
        assertEquals("testValue", response.getKey());
    }

    @Test
    void testDeleteKey() {
        RedisStringRequest request = new RedisStringRequest();
        request.setKey("testKey");
        when(redisTemplate.delete("testKey")).thenReturn(true);
        boolean deleted = redisService.deleteKey(request);
        assertTrue(deleted);
    }
}

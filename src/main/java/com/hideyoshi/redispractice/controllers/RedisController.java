package com.hideyoshi.redispractice.controllers;

import com.hideyoshi.redispractice.entity.dto.RedisStringRequest;
import com.hideyoshi.redispractice.entity.dto.RedisStringResponse;
import com.hideyoshi.redispractice.services.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @GetMapping("/get")
    public ResponseEntity<RedisStringResponse> getRedisString(@RequestBody RedisStringRequest request) {
        return ResponseEntity.ok().body(redisService.getValue(request));
    }

    @PostMapping("/set")
    public ResponseEntity<RedisStringResponse> setRedisString(@RequestBody RedisStringRequest request) {
        return ResponseEntity.ok().body(redisService.setValue(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteRedisString(@RequestBody RedisStringRequest request) {
        return ResponseEntity.ok().body(redisService.deleteKey(request));
    }
}

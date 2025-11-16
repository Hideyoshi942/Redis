package com.hideyoshi.redispractice.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RedisStringResponse {
    private String key;
}

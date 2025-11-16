package com.hideyoshi.redispractice.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedisStringRequest {
    private String key;
    private String value;
}

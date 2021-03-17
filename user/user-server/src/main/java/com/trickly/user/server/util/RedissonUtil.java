package com.trickly.user.server.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonUtil {

    public static void main(String[] args) {
        RedissonClient redissonClient = Redisson.create(new Config());
    }
}

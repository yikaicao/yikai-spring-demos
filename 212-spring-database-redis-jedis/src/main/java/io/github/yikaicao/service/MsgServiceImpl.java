package io.github.yikaicao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setMsg(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getMsg(String key) {
        return String.valueOf(redisTemplate.opsForValue().get(key));
    }
}

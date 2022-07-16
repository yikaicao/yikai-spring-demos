package io.github.yikaicao.controller;

import io.github.yikaicao.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/jedis/hello")
    public Object testJedis() {
        Object value = redisTemplate.opsForValue().get("name");
        if (value == null) {
            redisTemplate.opsForValue().set("name", "jedis");
            value = redisTemplate.opsForValue().get("name");
        }
        return value;
    }

    @GetMapping("/lettuce/hello")
    public Object testLettuce() {
        Object value = redisTemplate.opsForValue().get("name");
        if (value == null) {
            redisTemplate.opsForValue().set("name", "lettuce");
            value = redisTemplate.opsForValue().get("name");
        }
        return value;
    }

    @GetMapping("/query/hello")
    public Object testSection(@RequestParam("key") String key) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value == null) {
            redisTemplate.opsForValue().set(key, key);
            value = redisTemplate.opsForValue().get(key);
        }
        return value;
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        redisTemplate.opsForValue().set(employee.getId(), employee);
    }

    @GetMapping("/")
    public boolean root() {
        return true;
    }

}

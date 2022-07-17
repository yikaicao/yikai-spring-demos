package io.github.yikaicao.controller;

import io.github.yikaicao.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        redisTemplate.opsForValue().set(employee.getId(), employee);
    }

    @GetMapping("/employee")
    public String getEmployee(@RequestParam String id) {
        return String.valueOf(redisTemplate.opsForValue().get(id));
    }

    @GetMapping("/")
    public boolean root() {
        return true;
    }

}

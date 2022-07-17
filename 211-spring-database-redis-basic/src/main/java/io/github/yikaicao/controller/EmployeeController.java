package io.github.yikaicao.controller;

import io.github.yikaicao.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private RedisTemplate<String, Employee> redisTemplate;

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
        redisTemplate.opsForValue().set(employee.getId(), employee);
    }

    @GetMapping("/")
    public boolean root() {
        return true;
    }

}

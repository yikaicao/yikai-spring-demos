package io.github.yikaicao.controller;

import io.github.yikaicao.entity.Msg;
import io.github.yikaicao.service.MsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MsgController {
    @Autowired
    private MsgServiceImpl msgService;

    @PostMapping("/msg")
    public void setMsg(@RequestBody Msg msg) {
        msgService.setMsg(msg.getKey(), msg.getValue());
    }

    @GetMapping("/msg")
    public String getMsg(@RequestParam String key) {
        return msgService.getMsg(key);
    }
}

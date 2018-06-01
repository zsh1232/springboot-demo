package com.zsh.demo.controller;

import com.zsh.demo.domain.resp.Response;
import com.zsh.demo.kafka.producer.KafkaSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/kafka")
public class KafkaDemoController {

    @Resource
    private KafkaSender kafkaSender;

    @RequestMapping(value = "/send")
    public Object send(@RequestParam(name = "topic") String topic,
                       @RequestParam(name = "msg") String msg) {
        Response resp = Response.error();
        if(kafkaSender.send(topic, msg)) {
            resp = Response.ok().data(topic+" "+msg);
        }
        return resp;
    }
}

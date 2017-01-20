package com.xiaody.application.controller;

import com.xiaody.application.kafka.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xiaody on 2017/1/19.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaMessageProducer producer;

    @RequestMapping(value = "/send")
    public String sendMessage(@RequestParam("msg") String msg) {
        producer.send("test", msg);
        return "123";
    }
}

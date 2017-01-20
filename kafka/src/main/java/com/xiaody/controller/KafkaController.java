package com.xiaody.controller;

import com.xiaody.bean.ResponseResult;
import com.xiaody.service.IKafkaService;
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
    private IKafkaService kafkaService;

    @RequestMapping(value = "/send")
    public ResponseResult sendMessage(@RequestParam("msg") String msg) {
        kafkaService.send("bupt", msg);
        return new ResponseResult();
    }
}

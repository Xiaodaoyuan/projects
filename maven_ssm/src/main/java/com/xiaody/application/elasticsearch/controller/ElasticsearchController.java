package com.xiaody.application.elasticsearch.controller;

import com.xiaody.application.elasticsearch.model.Account;
import com.xiaody.application.elasticsearch.service.AccountElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Xiaody on 2017/1/10.
 */
@Controller
@RequestMapping("/account")
public class ElasticsearchController {

    @Autowired
    private AccountElasticsearchService accountElasticsearchService;

    @RequestMapping("/getByName/{name}")
    @ResponseBody
    public Account getByName(@PathVariable String name) {
        return accountElasticsearchService.getByName(name);
    }
}

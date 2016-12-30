package com.xiaody.elasticsearch.service.impl;

import com.xiaody.elasticsearch.model.Account;
import com.xiaody.elasticsearch.service.ElasticsearchService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Xiaody on 2016/12/29.
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService,InitializingBean{

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!elasticsearchTemplate.indexExists("bank")) {
            elasticsearchTemplate.createIndex("bank");
        }
//        elasticsearchTemplate.putMapping(Account.class);
    }

    @Override
    public String print() {
        System.out.println("-------------------------");
        return "abc";
    }
}

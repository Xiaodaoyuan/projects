package com.xiaody.application.elasticsearch;

import com.xiaody.application.elasticsearch.model.Account;
import com.xiaody.application.elasticsearch.service.AccountElasticsearchService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Xiaody on 2017/1/9.
 */
@ContextConfiguration(locations = {"classpath:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestElasticsearchService {

    @Autowired
    private AccountElasticsearchService accountElasticsearchService;


//    @Ignore
    @Test
    public void testGetAll(){
        long count = accountElasticsearchService.count();
        System.out.println(count);
    }
}

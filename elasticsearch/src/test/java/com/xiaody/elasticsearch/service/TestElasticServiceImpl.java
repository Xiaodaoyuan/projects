package com.xiaody.elasticsearch.service;

import com.xiaody.elasticsearch.model.Account;
import com.xiaody.elasticsearch.respository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Xiaody on 2016/12/29.
 */
@ContextConfiguration(locations = {"classpath:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestElasticServiceImpl {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void  testElasticsearch(){
        List<Account> l = accountRepository.getByFirstname("Aurelia");
        System.out.println(l.size());
        for(Account account:l){
            System.out.println(account.getAccount_number());
            System.out.println(account.getAddress());
            System.out.println(account.getFirstname());
        }
    }

}

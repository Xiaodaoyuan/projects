package com.xiaody.application.elasticsearch.service.impl;

import com.xiaody.application.elasticsearch.model.Account;
import com.xiaody.application.elasticsearch.repository.AccountRepository;
import com.xiaody.application.elasticsearch.service.AccountElasticsearchService;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by Xiaody on 2017/1/9.
 */
@Service
public class AccountElasticsearchServiceImpl implements AccountElasticsearchService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public long count() {
        return accountRepository.count();
    }

    @Override
    public Account getByName(String name) {
        return accountRepository.getByFirstname(name);
    }

    @Override
    public List<Account> search() {
        return null;
    }
}

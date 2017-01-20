package com.xiaody.application.elasticsearch.service;

import com.xiaody.application.elasticsearch.model.Account;

import java.util.List;

/**
 * Created by Xiaody on 2017/1/9.
 */
public interface AccountElasticsearchService {

    long count();

    Account getByName(String name);

    List<Account> search();
}

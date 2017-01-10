package com.xiaody.application.elasticsearch.repository;

import com.xiaody.application.elasticsearch.model.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Xiaody on 2017/1/9.
 */
@Repository
public interface AccountRepository extends ElasticsearchRepository<Account,String>{

    Account getByFirstname(String name);
}

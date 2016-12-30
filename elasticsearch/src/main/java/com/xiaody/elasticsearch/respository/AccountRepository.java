package com.xiaody.elasticsearch.respository;

import com.xiaody.elasticsearch.model.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Xiaody on 2016/12/29.
 */
@Repository
public interface AccountRepository extends ElasticsearchRepository<Account, String> {

    List<Account> getByFirstname(String firstname);
}

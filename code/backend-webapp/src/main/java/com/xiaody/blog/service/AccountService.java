package com.xiaody.blog.service;

import com.xiaody.blog.model.Account;
import com.xiaody.blog.model.options.AccountSearchOptions;

import java.util.List;

/**
 * Created by Xiaody on 2016/9/29.
 */
public interface AccountService extends BaseService<Account> {
    Account register(Account account);

    Account login(Account account);

    List<Account> searchByPage(AccountSearchOptions options);
}

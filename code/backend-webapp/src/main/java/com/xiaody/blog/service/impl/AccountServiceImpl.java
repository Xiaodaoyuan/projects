package com.xiaody.blog.service.impl;

import com.xiaody.blog.dao.AccountMapper;
import com.xiaody.blog.model.Account;
import com.xiaody.blog.model.options.AccountSearchOptions;
import com.xiaody.blog.service.AccountService;
import com.xiaody.blog.util.CheckUtil;
import com.xiaody.blog.util.DateUtil;
import com.xiaody.blog.util.EncryptUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xiaody on 2016/9/29.
 */
@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountMapper> implements AccountService {

    @Override
    public Account register(Account account) {
        CheckUtil.checkNull(account, "account");

        if (!CheckUtil.validateMobile(account.getMobile())) {
            throw new RuntimeException("mobile is missing or incorrect");
        }
        if (!CheckUtil.validatePassword(account.getPassword())) {
            throw new RuntimeException("password is missing or incorrect");
        }
        if (mapper.checkMobileExists(account.getMobile())) {
            throw new RuntimeException("mobile is exist");
        }

        account.setPassword(EncryptUtil.hash(account.getPassword()));
        account.setUserName(account.getMobile());
        account.setLastLoginTime(DateUtil.now());

        account = create(account);
        return account;
    }

    @Override
    public Account login(Account account) {
        CheckUtil.checkString(account.getMobile(), "mobile");
        CheckUtil.checkString(account.getPassword(), "password");
        Account result = mapper.checkMobileLogin(account.getMobile(), EncryptUtil.hash(account.getPassword()));
        if (result == null) {
            throw new RuntimeException("Login Failed");
        }
        updateLastLoginTime(result);
        return result;
    }

    @Override
    public List<Account> searchByPage(AccountSearchOptions options) {
        return mapper.searchByPage(options);
    }

    private void updateLastLoginTime(Account account) {
        account.setLastLoginTime(DateUtil.now());
        update(account);
    }
}

package com.xiaody.springboot.service.impl;

import org.springframework.stereotype.Service;

import com.xiaody.springboot.dao.AccountMapper;
import com.xiaody.springboot.model.Account;
import com.xiaody.springboot.service.AccountService;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountMapper> implements AccountService {

}

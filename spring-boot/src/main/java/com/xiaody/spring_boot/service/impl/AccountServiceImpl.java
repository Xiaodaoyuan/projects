package com.xiaody.spring_boot.service.impl;

import com.xiaody.common.service.impl.BaseServiceImpl;
import com.xiaody.spring_boot.dao.AccountMapper;
import com.xiaody.spring_boot.model.Account;
import com.xiaody.spring_boot.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountMapper> implements AccountService {

}

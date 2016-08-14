package com.xiaody.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.application.dao.AccountMapper;
import com.xiaody.application.model.Account;
import com.xiaody.application.service.AccountService;
import static com.xiaody.application.util.CommonUtils.*;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Account create(Account account) {
		accountMapper.create(account);
		return account;
	}

	@Override
	public Account update(Integer id, Account account) {
		account.setUpdateTime(now());
		accountMapper.update(id, account);
		return account;
	}

	@Override
	public void delete(Integer id) {
		accountMapper.delete(id);
	}

	@Override
	public Account get(Integer id) {
		return accountMapper.get(id);
	}

}

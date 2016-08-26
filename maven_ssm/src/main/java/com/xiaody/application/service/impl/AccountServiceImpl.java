package com.xiaody.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.xiaody.application.dao.AccountMapper;
import com.xiaody.application.model.Account;
import com.xiaody.application.service.AccountService;
import com.xiaody.application.util.Utils;

import static com.xiaody.application.util.Utils.*;

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

	@Override
	public Account login(Account account) {
		Assert.notNull(account.getUserName(), "username can not be null");
		Assert.notNull(account.getPassword(), "password can not be null");
		Account result = accountMapper.checkUsernameLogin(account.getUserName(), Utils.hash(account.getPassword()));
		if (result != null) {
			updateLastLoginTime(result.getId());
		}
		return result;
	}

	private Account updateLastLoginTime(Integer userId) {
		Account account = accountMapper.get(userId);
		if (account != null) {
			account.setLastLoginTime(Utils.now());
			update(userId, account);
		}
		return account;
	}

}

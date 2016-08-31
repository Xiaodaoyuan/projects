package com.xiaody.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.xiaody.application.dao.AccountMapper;
import com.xiaody.application.model.Account;
import com.xiaody.application.model.options.AccountSearchOptions;
import com.xiaody.application.service.AccountService;
import com.xiaody.application.util.Utils;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, AccountMapper> implements AccountService {

	@Override
	public Account login(Account account) {
		Assert.notNull(account.getUserName(), "username can not be null");
		Assert.notNull(account.getPassword(), "password can not be null");
		Account result = mapper.checkUsernameLogin(account.getUserName(), Utils.hash(account.getPassword()));
		if (result != null) {
			updateLastLoginTime(result.getId());
		}
		return result;
	}

	private Account updateLastLoginTime(Integer userId) {
		Account account = mapper.get(userId);
		if (account != null) {
			account.setLastLoginTime(Utils.now());
			update(userId, account);
		}
		return account;
	}

	@Override
	public List<Account> searchByPage(AccountSearchOptions option) {
		return mapper.searchByPage(option);
	}

}

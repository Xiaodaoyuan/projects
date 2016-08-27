package com.xiaody.application.service;

import java.util.List;

import com.xiaody.application.model.Account;
import com.xiaody.application.model.option.AccountSearchOptions;

public interface AccountService {
	Account create(Account account);

	Account update(Integer id, Account account);

	void delete(Integer id);

	Account get(Integer id);
	
	Account login(Account account);
	
	List<Account> searchByPage(AccountSearchOptions option);

}

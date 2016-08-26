package com.xiaody.application.service;

import com.xiaody.application.model.Account;

public interface AccountService {
	Account create(Account account);

	Account update(Integer id, Account account);

	void delete(Integer id);

	Account get(Integer id);
	
	Account login(Account account);

}

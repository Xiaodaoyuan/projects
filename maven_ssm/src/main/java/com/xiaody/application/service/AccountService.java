package com.xiaody.application.service;

import java.util.List;

import com.xiaody.application.model.Account;
import com.xiaody.application.model.options.AccountSearchOptions;

public interface AccountService extends BaseService<Account>{

	Account login(Account account);

	List<Account> searchByPage(AccountSearchOptions option);

}

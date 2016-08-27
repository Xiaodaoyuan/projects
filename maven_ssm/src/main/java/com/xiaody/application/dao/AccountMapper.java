package com.xiaody.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaody.application.model.Account;
import com.xiaody.application.model.option.AccountSearchOptions;

public interface AccountMapper {
	void create(@Param("account") Account account);

	void update(@Param("id") Integer id, @Param("account") Account account);

	void delete(@Param("id") Integer id);

	Account get(@Param("id") Integer id);
	
	Account checkUsernameLogin(@Param("userName")String userName,@Param("password")String password);

	List<Account> searchByPage(@Param("option")AccountSearchOptions option);

}

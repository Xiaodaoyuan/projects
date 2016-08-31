package com.xiaody.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaody.application.model.Account;
import com.xiaody.application.model.options.AccountSearchOptions;

public interface AccountMapper extends BaseMapper<Account>{
	
	Account checkUsernameLogin(@Param("userName")String userName,@Param("password")String password);

	List<Account> searchByPage(@Param("option")AccountSearchOptions option);

}

package com.xiaody.application.dao;

import org.apache.ibatis.annotations.Param;

import com.xiaody.application.model.Account;

public interface AccountMapper {
	void create(@Param("account") Account account);

	void update(@Param("id") Integer id, @Param("account") Account account);

	void delete(@Param("id") Integer id);

	Account get(@Param("id") Integer id);
}

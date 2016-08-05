package com.xiaody.application.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.application.BaseTest;
import com.xiaody.application.model.Account;
import com.xiaody.application.model.enums.UserType;

public class TestAccountServiceImpl extends BaseTest{

	@Autowired
	private AccountService accountService;
	
	public void testCreate(){
		Account account =new Account();
		account.setBirthDate(new Date());
		account.setEmail("1307120838@qq.com");
		account.setUserName("xiaody");
		account.setNickName("xiaoxiao");
		account.setMobile("13718363267");
		account.setPassword("123456");
		account.setUserType(UserType.GENERAL_USER);
		Account a= accountService.create(account);
		System.out.println(a.getUserName());
		System.out.println(a.getCreateTime());
	}
	
	@Test
	public void testGet(){
		accountService.get(1);
	}
	
}

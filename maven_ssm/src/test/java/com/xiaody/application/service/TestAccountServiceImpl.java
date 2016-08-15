package com.xiaody.application.service;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.Account;

@ContextConfiguration(locations = { "classpath:application.xml" }) 
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAccountServiceImpl{

	@Autowired
	private AccountService accountService;
	
	@Ignore
	@Test
	public void testCreate(){
		Account account =new Account();
		account.setBirthDate(new Date());
		account.setEmail("1307120838@qq.com");
		account.setUserName("xiaody");
		account.setNickName("xiaoxiao");
		account.setMobile("13718363267");
		account.setPassword("123456");
		account.setGender("��");
		account.setUserType(1);
		Account a= accountService.create(account);
		System.out.println(a.getId());
		System.out.println(a.getUserName());
		System.out.println(a.getCreateTime());
	}
	
	@Ignore
	@Test
	public void testGet(){
		accountService.get(1);
	}
	
}

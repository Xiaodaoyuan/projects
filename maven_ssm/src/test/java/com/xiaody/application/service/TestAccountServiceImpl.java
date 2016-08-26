package com.xiaody.application.service;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.Account;
import com.xiaody.application.model.enums.UserType;
import com.xiaody.application.util.Utils;

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
		account.setGender("ÄÐ");
		account.setUserType(UserType.SYSTEM);
		Account a= accountService.create(account);
		System.out.println(a.getId());
		System.out.println(a.getUserName());
		System.out.println(a.getCreateTime());
	}
	
	@Test
	public void testGet(){
		Account a =accountService.get(2);
		System.out.println(a.getUserType());
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		Account a =accountService.get(2);
		a.setUserName("xiaoxiao");
		a.setMobile("15279227857");
		a.setNickName("xiao");
		a.setGender("Å®");
		a.setPassword(Utils.hash(a.getPassword()));
		accountService.update(a.getId(), a);
	}
	
}

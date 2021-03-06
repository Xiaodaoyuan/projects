package com.xiaody.application.service;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.Account;
import com.xiaody.application.model.enums.UserType;
import com.xiaody.application.model.options.AccountSearchOptions;
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
		account.setUserName("xiaody5");
		account.setNickName("xiaoxiao");
		account.setMobile("13718363267");
		account.setPassword(Utils.hash("123456"));
		account.setGender("��");
		account.setUserType(UserType.DIAMOND_USER);
		Account a= accountService.create(account);
		System.out.println(a.getId());
		System.out.println(a.getUserName());
		System.out.println(a.getCreateTime());
	}
	
	@Ignore
	@Test
	public void testGet(){
		long start =System.currentTimeMillis();
		Account a =accountService.get(2);
		System.out.println(a.getUserType());
		System.out.println(System.currentTimeMillis()-start);
	}
	
	@Ignore
	@Test
	public void testUpdate(){
		Account a =accountService.get(1);
		a.setUserName("xiaoxiao");
		a.setMobile("15279227857");
		a.setNickName("xiao");
		a.setGender("Ů");
		a.setPassword(Utils.hash("111111"));
		accountService.update(a.getId(), a);
	}
	@Ignore
	@Test
	public void testSearchByPage(){
		AccountSearchOptions option =new AccountSearchOptions();
		option.setPageNo(1);
		option.setPageSize(1);
		List<Account> list = accountService.searchByPage(option);
		System.out.println(list.size());
		System.out.println(option.getTotalNum());
	}
}

package com.xiaody.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.springboot.model.Account;
import com.xiaody.springboot.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@SuppressWarnings("unused")
	private Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account get(@PathVariable Integer id) {
		return accountService.get(id);
	}
}

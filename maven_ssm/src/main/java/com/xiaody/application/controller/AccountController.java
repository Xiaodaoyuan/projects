package com.xiaody.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaody.application.model.Account;

@Controller
@RequestMapping("/users")
public class AccountController {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Account account) {
		return "register_success";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Account account) {
		return "login_success";
	}
}

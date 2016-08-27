package com.xiaody.application.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xiaody.application.model.Account;
import com.xiaody.application.service.AccountService;

@Controller
@RequestMapping("/users")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Account account) {
		return "register_success";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Account account,HttpSession session) {
		ModelAndView modelAndView =new ModelAndView();
		Account login = accountService.login(account);
		if (login != null) {
			session.setAttribute("userId", login.getId());
			session.setAttribute("userName", login.getUserName());
			modelAndView.setViewName("login_success");
			return modelAndView;
		}
		modelAndView.setViewName("login");
		modelAndView.addObject("login_error", "用户名或密码错误！");
		return modelAndView;
	}
}

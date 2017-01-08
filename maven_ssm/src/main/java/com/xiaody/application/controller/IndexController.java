package com.xiaody.application.controller;

import com.xiaody.application.token.IgnoreSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@IgnoreSecurity
	@RequestMapping("/index")
	public String index() {
		LOGGER.info("index!");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		LOGGER.info("login!");
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		LOGGER.info("register!");
		return "register";
	}
}

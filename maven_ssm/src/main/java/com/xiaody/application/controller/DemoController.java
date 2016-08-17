package com.xiaody.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
	protected final Logger LOGGER =LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/hello")
	public String hello(){
		LOGGER.info("hello spring mvc!");
		return "index";
	}
	
	@RequestMapping("/head")
	public String head(){
		return "header";
	}
	
	@RequestMapping("/foot")
	public String foot(){
		return "footer";
	}

}

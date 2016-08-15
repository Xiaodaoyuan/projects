package com.xiaody.spring_boot_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/{id}")
	public User view(@PathVariable("id") Integer id) {
		User user = new User();
		user.setId(id);
		user.setName("zhang");
		return user;
	}
	
	@RequestMapping("/hello/say")
	public String hello(){
		return "hello world";
	}
}

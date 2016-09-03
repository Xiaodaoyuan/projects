package com.xiaody.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.spring_boot_demo.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/login")
	public User login(){
		User u =new User();
		u.setName("xiaoxiao");
		return u;
	}
	
}

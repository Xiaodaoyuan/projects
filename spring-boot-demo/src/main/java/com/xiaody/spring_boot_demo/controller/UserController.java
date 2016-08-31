package com.xiaody.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.spring_boot_demo.model.Users;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/login")
	public Users login(){
		Users u =new Users();
		u.setName("xiaoxiao");
		return u;
	}
	
}

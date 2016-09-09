package com.xiaody.spring_boot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.spring_boot_demo.model.User;
import com.xiaody.spring_boot_demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Integer id) {
		return userService.get(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody User user) {
		return userService.mobileLogin(user);
	}

}

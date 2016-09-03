package com.xiaody.spring_boot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.spring_boot_demo.model.Blog;
import com.xiaody.spring_boot_demo.service.BlogService;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Blog get(@PathVariable("id") Integer id) {
		return blogService.get(id);
	}
}

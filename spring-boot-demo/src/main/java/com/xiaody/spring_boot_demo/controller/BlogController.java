package com.xiaody.spring_boot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Blog create(@RequestBody Blog blog) {
		return blogService.create(blog);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Blog get(@PathVariable Integer id) {
		return blogService.get(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Blog update(@RequestBody Blog blog) {
		return blogService.update(blog);
	}

}

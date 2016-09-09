package com.xiaody.spring_boot_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.spring_boot_demo.model.Comment;
import com.xiaody.spring_boot_demo.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Comment create(@RequestBody Comment comment) {
		return commentService.create(comment);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Comment get(@PathVariable Integer id) {
		return commentService.get(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Comment update(@RequestBody Comment comment) {
		return commentService.update(comment);
	}
}

package com.xiaody.blog.controller;

import com.xiaody.blog.model.Blog;
import com.xiaody.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xiaody on 2016/9/30.
 */
@RestController
@RequestMapping("/blogs")
public class BlogController extends BaseController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Blog create(Blog blog) {
        return blogService.create(blog);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Blog update(Blog blog) {
        return blogService.update(blog);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Blog get(@PathVariable("id") Integer id) {
        return blogService.get(id);
    }
}

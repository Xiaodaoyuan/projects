package com.xiaody.blog.controller;

import com.xiaody.blog.model.Account;
import com.xiaody.blog.service.AccountService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xiaody on 2016/9/30.
 */
@RestController
@RequestMapping("/comments")
public class CommentController extends BaseController{

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Account create(Account account) {
        return accountService.create(account);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Account update(Account account) {
        return accountService.update(account);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account get(@PathVariable("id") Integer id) {
        return accountService.get(id);
    }
}

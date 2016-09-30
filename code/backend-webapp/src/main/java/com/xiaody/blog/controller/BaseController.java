package com.xiaody.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xiaody on 2016/9/30.
 */
public class BaseController implements ErrorController {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Boolean isJson(HttpServletRequest request) {
        String header = request.getHeader("content-type");
        return header != null && header.contains("json");
    }

    @ExceptionHandler(Exception.class)
    public Object handleBaseException(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error");
        modelAndView.addObject("exception", e);
        return modelAndView;

    }

    @Override
    public String getErrorPath() {
        return null;
    }
}

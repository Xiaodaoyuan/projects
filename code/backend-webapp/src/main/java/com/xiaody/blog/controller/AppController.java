package com.xiaody.blog.controller;

import com.xiaody.blog.constants.TemplateConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Xiaody on 2016/9/30.
 */
@Controller
public class AppController extends BaseController {

    @RequestMapping("/home")
    public String home(Map<String, String> model) {
        model.put("x", "xiaody");
        return TemplateConstants.HOME;
    }


    @RequestMapping("/login")
    public String login() {
        return TemplateConstants.LOGIN;
    }

    @RequestMapping("/register")
    public String register() {
        return TemplateConstants.REGISTER;
    }
}

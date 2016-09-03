package com.xiaody.spring_boot_demo.service.impl;

import org.springframework.stereotype.Service;

import com.xiaody.spring_boot_demo.dao.BaseDao;
import com.xiaody.spring_boot_demo.model.Blog;
import com.xiaody.spring_boot_demo.service.BlogService;

@Service
public class BlogServiceImpl extends BaseServiceImpl<Blog, BaseDao<Blog>> implements BlogService {

}

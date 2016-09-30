package com.xiaody.blog.service.impl;

import com.xiaody.blog.dao.BlogMapper;
import com.xiaody.blog.model.Blog;
import com.xiaody.blog.service.BlogService;
import org.springframework.stereotype.Service;

/**
 * Created by Xiaody on 2016/9/29.
 */
@Service
public class BlogServiceImpl extends BaseServiceImpl<Blog, BlogMapper> implements BlogService {
}

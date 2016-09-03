package com.xiaody.spring_boot_demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.xiaody.spring_boot_demo.dao.BlogDao;
import com.xiaody.spring_boot_demo.model.Blog;

@Repository
public class BlogDaoImpl extends BaseDaoImpl<Blog> implements BlogDao {

}

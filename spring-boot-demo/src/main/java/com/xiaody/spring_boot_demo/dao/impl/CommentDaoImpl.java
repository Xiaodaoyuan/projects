package com.xiaody.spring_boot_demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.xiaody.spring_boot_demo.dao.CommentDao;
import com.xiaody.spring_boot_demo.model.Comment;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao {

}

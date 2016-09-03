package com.xiaody.spring_boot_demo.service.impl;

import org.springframework.stereotype.Service;

import com.xiaody.spring_boot_demo.dao.BaseDao;
import com.xiaody.spring_boot_demo.model.Comment;
import com.xiaody.spring_boot_demo.service.CommentService;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, BaseDao<Comment>> implements CommentService {

}

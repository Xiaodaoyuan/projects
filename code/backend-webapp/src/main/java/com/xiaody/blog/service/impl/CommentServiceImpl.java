package com.xiaody.blog.service.impl;

import com.xiaody.blog.dao.CommentMapper;
import com.xiaody.blog.model.Comment;
import com.xiaody.blog.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * Created by Xiaody on 2016/9/29.
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentMapper> implements CommentService {
}

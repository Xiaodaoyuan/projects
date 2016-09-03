package com.xiaody.spring_boot_demo.service.impl;

import org.springframework.stereotype.Service;

import com.xiaody.spring_boot_demo.dao.BaseDao;
import com.xiaody.spring_boot_demo.model.User;
import com.xiaody.spring_boot_demo.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseDao<User>> implements UserService {

}

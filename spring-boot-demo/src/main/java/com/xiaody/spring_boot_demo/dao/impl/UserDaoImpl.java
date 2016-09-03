package com.xiaody.spring_boot_demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.xiaody.spring_boot_demo.dao.UserDao;
import com.xiaody.spring_boot_demo.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

}

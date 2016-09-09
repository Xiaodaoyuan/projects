package com.xiaody.spring_boot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.xiaody.spring_boot_demo.dao.BaseDao;
import com.xiaody.spring_boot_demo.dao.UserDao;
import com.xiaody.spring_boot_demo.model.User;
import com.xiaody.spring_boot_demo.service.UserService;
import com.xiaody.spring_boot_demo.util.Utils;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, BaseDao<User>> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User mobileLogin(User user) {
		Assert.notNull(user.getMobile(), "user mobile can not be null");
		Assert.notNull(user.getPassword(), "user password can not be null");
		User userLogin = userDao.getByMobile(user.getMobile(), Utils.hash(user.getPassword()));
		if (userLogin == null)
			throw new RuntimeException("用户名或密码不匹配");
		return userLogin;
	}

}

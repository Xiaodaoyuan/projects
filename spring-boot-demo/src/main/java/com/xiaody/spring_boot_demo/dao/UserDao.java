package com.xiaody.spring_boot_demo.dao;

import com.xiaody.spring_boot_demo.model.User;

public interface UserDao extends BaseDao<User> {
	
	User getByMobile(String mobile, String password);
}

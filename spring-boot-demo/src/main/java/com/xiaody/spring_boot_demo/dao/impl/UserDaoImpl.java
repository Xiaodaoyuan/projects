package com.xiaody.spring_boot_demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaody.spring_boot_demo.dao.UserDao;
import com.xiaody.spring_boot_demo.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	public User getByMobile(String mobile, String password) {
		String hql = "from User u where u.mobile = ? and u.password= ?";
		List<User> users = (List<User>) hibernateTemplate.find(hql, mobile, password);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}

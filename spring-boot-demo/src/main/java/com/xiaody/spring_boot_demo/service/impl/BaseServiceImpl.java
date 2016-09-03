package com.xiaody.spring_boot_demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.spring_boot_demo.dao.BaseDao;
import com.xiaody.spring_boot_demo.service.BaseService;

public abstract class BaseServiceImpl<T, DAO extends BaseDao<T>> implements BaseService<T> {

	@Autowired
	protected DAO dao;

	@Override
	public T create(T entity) {
		return dao.create(entity);
	}

	@Override
	public T update(T entity) {
		return dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public T get(Integer id) {
		return dao.get(id);
	}

}

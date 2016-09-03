package com.xiaody.spring_boot_demo.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.xiaody.spring_boot_demo.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	protected HibernateTemplate hibernateTemplate;

	protected Class<T> modelClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		modelClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public T create(T entity) {
		hibernateTemplate.save(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		hibernateTemplate.update(entity);
		return entity;
	}

	@Override
	public void delete(Integer id) {
		hibernateTemplate.delete(id);
	}

	@Override
	public T get(Integer id) {
		return hibernateTemplate.get(modelClass, id);
	}

}

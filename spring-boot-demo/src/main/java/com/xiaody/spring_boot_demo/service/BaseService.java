package com.xiaody.spring_boot_demo.service;

public interface BaseService<T> {

	T create(T entity);

	T update(T entity);

	void delete(Integer id);

	T get(Integer id);
}

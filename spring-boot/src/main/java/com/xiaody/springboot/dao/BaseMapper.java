package com.xiaody.springboot.dao;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T> {

	void create(@Param("entity") T entity);

	void update(@Param("entity") T entity);

	T get(@Param("id") Integer id);

	void delete(@Param("id") Integer id);
}

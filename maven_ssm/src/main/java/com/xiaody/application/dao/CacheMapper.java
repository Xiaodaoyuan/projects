package com.xiaody.application.dao;

import org.apache.ibatis.annotations.Param;

import com.xiaody.application.model.cache.Cache;

public interface CacheMapper {
	void create(@Param("cache") Cache cache);

	void update(@Param("cache") Cache cache);

	void delete(@Param("id") Integer id);

	Cache get(@Param("id") Integer id);

	Cache getByKey(@Param("key") String key);
}

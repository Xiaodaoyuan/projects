package com.xiaody.application.dao;

import org.apache.ibatis.annotations.Param;

import com.xiaody.application.model.cache.Cache;

public interface CacheMapper extends BaseMapper<Cache> {

	Cache getByKey(@Param("key") String key);
}

package com.xiaody.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.application.dao.CacheMapper;
import com.xiaody.application.model.cache.Cache;
import com.xiaody.application.service.CacheService;
import com.xiaody.application.util.CommonUtils;

public class CacheServiceImpl implements CacheService {

	@Autowired
	private CacheMapper cacheMapper;

	@Override
	public Cache create(Cache cache) {
		cacheMapper.create(cache);
		return cache;
	}

	@Override
	public Cache update(Cache cache) {
		cache.setUpdateTime(CommonUtils.now());
		cacheMapper.update(cache);
		return cache;
	}

	@Override
	public void delete(Integer id) {
		cacheMapper.delete(id);
	}

	@Override
	public Cache get(Integer id) {
		return cacheMapper.get(id);
	}

	@Override
	public Cache getByKey(String key) {
		return cacheMapper.getByKey(key);
	}

}

package com.xiaody.application.service.impl;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.application.cache.EhCacheFacade;
import com.xiaody.application.dao.CacheMapper;
import com.xiaody.application.model.cache.Cache;
import com.xiaody.application.service.CacheService;
import com.xiaody.application.util.CommonUtils;

public class CacheServiceImpl implements CacheService {

	@Autowired
	private CacheMapper cacheMapper;

	@Override
	public Cache create(Cache cache) {
		Cache existing = cacheMapper.getByKey(cache.getCacheKey());
		if (existing == null) {
			cacheMapper.create(cache);
		} else {
			update(existing.getId(), cache);
		}
		return cache;
	}

	@Override
	public Cache update(Integer id, Cache cache) {
		cache.setUpdateTime(CommonUtils.now());
		cacheMapper.update(id,cache);
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
	public Cache getByKey(final String key) {
		Cache cache = null;
		try {
			cache = EhCacheFacade.CACHE.get(key, new Callable<Cache>() {

				@Override
				public Cache call() throws Exception {
					return cacheMapper.getByKey(key);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cache;
	}

}

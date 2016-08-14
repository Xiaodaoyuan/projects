package com.xiaody.application.service;

import com.xiaody.application.model.cache.Cache;

public interface CacheService {
	Cache create(Cache cache);

	Cache update(Cache cache);

	void delete(Integer id);

	Cache get(Integer id);

	Cache getByKey(String key);
}

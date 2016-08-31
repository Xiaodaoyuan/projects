package com.xiaody.application.service;

import com.xiaody.application.model.cache.Cache;

public interface CacheService extends BaseService<Cache> {

	Cache getByKey(String key);
}

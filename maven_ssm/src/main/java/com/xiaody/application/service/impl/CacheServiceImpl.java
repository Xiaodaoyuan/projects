package com.xiaody.application.service.impl;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaody.application.cache.EhCacheFacade;
import com.xiaody.application.dao.CacheMapper;
import com.xiaody.application.model.cache.Cache;
import com.xiaody.application.service.CacheService;

@Service
public class CacheServiceImpl extends BaseServiceImpl<Cache, CacheMapper> implements CacheService {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Override
	public Cache create(Cache cache) {
		try {
			String storedValue = OBJECT_MAPPER.writeValueAsString(cache.getValue());

			Cache existing = mapper.getByKey(cache.getCacheKey());
			if (existing == null) {
				cache.setStoredValue(storedValue);
				mapper.create(cache);
			} else {
				cache.setStoredValue(storedValue);
				update(existing.getId(), cache);
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cache;
	}

	@Override
	public Cache getByKey(final String key) {
		Cache cache = null;
		try {
			cache = EhCacheFacade.CACHE.get(key, new Callable<Cache>() {

				@Override
				public Cache call() throws Exception {
					return mapper.getByKey(key);
				}
			});
			cache.setValue(OBJECT_MAPPER.readValue(cache.getStoredValue(), JsonNode.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cache;
	}

}

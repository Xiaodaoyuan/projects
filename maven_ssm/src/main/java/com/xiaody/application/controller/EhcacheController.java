package com.xiaody.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xiaody.application.model.cache.Cache;
import com.xiaody.application.service.CacheService;

@RestController
@RequestMapping("/cache")
public class EhcacheController {

	@Autowired
	private CacheService cacheService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Cache create(@RequestBody Cache cache) {
		return cacheService.create(cache);
	}
	
	@RequestMapping(value = "/key/{key}", method = RequestMethod.GET)
	public Cache getBykey(@PathVariable("key") String key) {
		Cache cache = cacheService.getByKey(key);
		cache.setStoredValue(null);
		return cache;
	}

}

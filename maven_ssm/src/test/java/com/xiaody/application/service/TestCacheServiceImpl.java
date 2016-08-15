package com.xiaody.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.cache.Cache;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCacheServiceImpl {

	@Autowired
	private CacheService cacheService;

	@Test
	public void createCache() {
		Cache cache = new Cache();
		cache.setCacheKey("name");
		cache.setStoredValue("{'name':'xiaody','age':24}");
		cacheService.create(cache);
		System.out.println("----------------");
	}
	
	@Test
	public void getByKey() {
		cacheService.getByKey("name");
		System.out.println("!!!!!!!!!!!!!!!!");
	}

}

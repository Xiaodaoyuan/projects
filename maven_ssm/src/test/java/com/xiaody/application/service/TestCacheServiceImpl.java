package com.xiaody.application.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaody.application.model.cache.Cache;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestCacheServiceImpl {

	@Autowired
	private CacheService cacheService;

	@Ignore
	@Test
	public void createCache() throws Exception {
		Cache cache = new Cache();
		cache.setCacheKey("name");
		ObjectMapper mapper = new ObjectMapper();
		// JSON ----> JsonNode
		String value = "{\"name\":\"xiaody\",\"age\":24}";
		JsonNode valueNode = mapper.readTree(value);
		cache.setValue(valueNode);
		cacheService.create(cache);
		System.out.println("----------------");
	}
	@Ignore
	@Test
	public void getByKey() {
		cacheService.getByKey("name");
		System.out.println("!!!!!!!!!!!!!!!!");
	}

}

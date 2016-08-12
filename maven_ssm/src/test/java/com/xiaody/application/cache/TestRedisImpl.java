package com.xiaody.application.cache;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.application.BaseTest;

public class TestRedisImpl extends BaseTest{
	
	@Autowired
	private RedisImpl redisCache1;
	
	@Ignore
	@Test
	public void testStrPut(){
		redisCache1.strPut("name", "xiaodyxiao");
	}

}

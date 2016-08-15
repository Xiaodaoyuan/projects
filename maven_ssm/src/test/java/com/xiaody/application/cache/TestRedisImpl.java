package com.xiaody.application.cache;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:application.xml" }) 
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedisImpl{
	
	@Autowired
	private RedisImpl redisCache1;
	
	@Ignore
	@Test
	public void testStrPut(){
		redisCache1.strPut("name", "xiaodyxiao");
	}

}

package com.xiaody.application.cache;

import com.xiaody.application.redis.SpringRedis;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringRedis {

    @Autowired
    private SpringRedis springRedis;

    @Test
    public void testPut() {
        springRedis.put("name", "xiaodyxiao");
    }

    @Test
    public void testGet() {
        String value = springRedis.get("name");
        System.out.println(value);
    }

    @Test
    public void testLPush() {
        springRedis.lPush("list", 1);
        springRedis.lPush("list", "qwerty");
    }

}

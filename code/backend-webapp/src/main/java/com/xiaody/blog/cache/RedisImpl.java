package com.xiaody.blog.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Xiaody on 2016/9/29.
 */
@Component
public class RedisImpl implements Cache {


    @Autowired
    private StringRedisTemplate template;

    @Resource(name = "redisTemplate")
    private ListOperations<Object, Object> listOps;

    public void hello() {
        //listOps.leftPush("xx22222", "22");
        System.out.println(listOps.range("xx", 0, 1));
        System.out.println(listOps.size("xx22222"));
    }
}

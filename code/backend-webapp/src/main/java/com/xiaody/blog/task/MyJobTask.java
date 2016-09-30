package com.xiaody.blog.task;

import com.xiaody.blog.cache.RedisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Xiaody on 2016/9/29.
 */
@Component
public class MyJobTask extends BaseTask {

    @Autowired
    private RedisImpl redisImpl;

    @Scheduled(cron = "0 0/2 * * * ?")
    public void execute() {
        LOGGER.info("MyJobTask start....");
        redisImpl.hello();
        LOGGER.info("MyJobTask end....");
    }
}

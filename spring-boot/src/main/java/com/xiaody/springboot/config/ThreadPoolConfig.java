package com.xiaody.springboot.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {

	@Bean(name = "myExecutor")
	public ThreadPoolTaskExecutor myThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor myExecutor = new ThreadPoolTaskExecutor();
		myExecutor.setCorePoolSize(2);
		myExecutor.setMaxPoolSize(100);
		myExecutor.setKeepAliveSeconds(3000);
		myExecutor.setQueueCapacity(4);
		myExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		return myExecutor;
	}
}

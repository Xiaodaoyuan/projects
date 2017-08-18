package com.xiaody.spring_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

	@Bean(name = "myExecutor")
	public ThreadPoolTaskExecutor myThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor myExecutor = new ThreadPoolTaskExecutor();
		myExecutor.setCorePoolSize(5);
		myExecutor.setMaxPoolSize(10);
		myExecutor.setKeepAliveSeconds(3000);
		myExecutor.setQueueCapacity(100);
		myExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		return myExecutor;
	}
}

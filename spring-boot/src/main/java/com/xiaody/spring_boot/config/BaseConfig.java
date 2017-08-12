package com.xiaody.spring_boot.config;

import com.xiaody.common.config.GlobalExceptionHandler;
import com.xiaody.common.filter.HttpRequestFilter;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author xiaody
 * @Description
 * @Date create in 17/8/9
 */
@Configuration
public class BaseConfig {


    @Bean
    public HttpRequestFilter httpRequestFilter() {
        return new HttpRequestFilter();
    }

    @Bean
    public GlobalExceptionHandler exceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
}

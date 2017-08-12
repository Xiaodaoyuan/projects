package com.xiaody.spring_boot.config;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Xiaody on 17/7/18.
 */
@Aspect
@Component
public class WebLogAspect {
    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();


//    @Pointcut("execution(public * com.xiaody.spring_boot.web..*.*(..))")
    @Pointcut("@annotation(com.xiaody.spring_boot.config.WebLog)")
    public void webLog() {
    }

    @Before("webLog()")
    public void before() {
        logger.info("before.....");
        startTime.set(System.currentTimeMillis());
    }

    @After("webLog()")
    public void after() {
        logger.info("after.....");

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret.toString());
        logger.info("cost time:{}", System.currentTimeMillis() - startTime.get());
    }
}

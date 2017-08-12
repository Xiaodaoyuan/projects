package com.xiaody.spring_boot.config;

import java.lang.annotation.*;

/**
 * Created by Xiaody on 17/7/21.
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {
}

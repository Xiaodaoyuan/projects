package com.xiaody.blog.util;

import java.util.Date;

/**
 * Created by Xiaody on 2016/9/29.
 */
public class DateUtil {

    public static Date now() {
        return new Date();
    }

    public static Long nowTime() {
        return now().getTime();
    }

}

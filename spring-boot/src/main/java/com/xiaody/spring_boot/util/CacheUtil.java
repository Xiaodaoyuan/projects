package com.xiaody.spring_boot.util;

/**
 * Created by Xiaody on 17/7/26.
 */
public class CacheUtil {

    private static final ThreadLocal<String> threadLocalUserID = new ThreadLocal<>();

    public static String getUserID() {
        return threadLocalUserID.get();
    }

    public static void setUserID(String userID) {
        threadLocalUserID.set(userID);
    }
}

package com.xiaody.blog.util;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xiaody on 2016/9/29.
 */
public class CheckUtil {
    private static final Pattern MOBILE_PATTERN = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[\\dA-Za-z(!@#$%&?.^*()]{6,20}$");

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^([a-z0-9A-Z]+[_-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^[-\\+]?[\\d]*$");

    public static boolean validateMobile(String mobile) {
        Matcher m = MOBILE_PATTERN.matcher(mobile);
        return m.matches();
    }

    public static boolean validatePassword(String password) {
        Matcher m = PASSWORD_PATTERN.matcher(password);
        return m.matches();
    }

    public static boolean validateEmail(String email) {
        Matcher m = EMAIL_PATTERN.matcher(email);
        return m.matches();
    }

    public static boolean validateInteger(String value) {
        Matcher m = INTEGER_PATTERN.matcher(value);
        return m.matches();
    }

    public static <T> T checkNull(Object param, String paramName) {
        if (param == null) {
            throw new RuntimeException("Missing filed " + paramName);
        }

        return (T) param;
    }

    public static String checkString(String param, String paramName) {
        if (param == null || param.trim().length() == 0) {
            throw new RuntimeException("Missing filed " + paramName);
        }

        return param;
    }

    public static boolean equals(String a, String b) {
        if (a == null && b == null)
            return true;

        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        return a.equalsIgnoreCase(b);
    }

    public static boolean equalsCaseSensitive(String a, String b) {
        if (a == null && b == null)
            return true;

        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        return a.equals(b);
    }

    public static boolean equals(Integer a, Integer b) {
        if (a == null && b == null)
            return true;

        if (a == null || b == null) {
            return false;
        }

        return a.equals(b);
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static <T> boolean isCollectionEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isArrayEmpty(Object[] objects) {
        return objects == null || (objects != null && objects.length == 0);
    }

    public static String nullIfEmpty(String value) {
        return isEmpty(value) ? null : value;
    }

    public static <T> List<T> nullIfEmpty(List<T> collections) {
        return isCollectionEmpty(collections) ? null : collections;
    }

    public static String isNull(String input, String defaultValue) {
        return input == null ? defaultValue : input;
    }

    public static Integer isNull(Integer input, Integer defaultValue) {
        return input == null ? defaultValue : input;
    }
}

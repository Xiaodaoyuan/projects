package com.xiaody.bean;

/**
 * Created by Xiaody on 2017/1/19.
 */
public class ResponseCode {
    /**
     * 调用成功响应码
     */
    public final static int REQUEST_SUCCESS = 200;

    /**
     * 拒绝IP响应码
     */
    public static final int REQUEST_ERROR_REFUSE_IP = -60;

    /**
     * 程序异常
     */
    public static final int REQUEST_ERROR_PROGRAM_EXCEPTION = -100;
}

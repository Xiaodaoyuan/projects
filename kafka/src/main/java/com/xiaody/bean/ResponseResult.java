package com.xiaody.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Xiaody on 2017/1/19.
 */
public class ResponseResult {
    private String msg = "正常调用";
    private int code = ResponseCode.REQUEST_SUCCESS;
    private Object data = new JSONObject();

    public ResponseResult() {
    }

    public ResponseResult(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public ResponseResult(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

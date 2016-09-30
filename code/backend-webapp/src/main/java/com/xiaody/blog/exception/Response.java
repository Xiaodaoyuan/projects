package com.xiaody.blog.exception;

/**
 * Created by Xiaody on 2016/9/29.
 */
public class Response {
    private static final String OK = "ok";
    private static final String ERROR = "error";
    private boolean success;
    private String message;

    public Response failure() {
        this.success = false;
        this.message = ERROR;
        return this;
    }

    public Response failure(String message) {
        this.success = false;
        this.message = message;
        return this;
    }

    public Response success() {
        this.success = true;
        this.message = OK;
        return this;
    }

    public Response success(String message) {
        this.success = true;
        this.message = message;
        return this;
    }

}

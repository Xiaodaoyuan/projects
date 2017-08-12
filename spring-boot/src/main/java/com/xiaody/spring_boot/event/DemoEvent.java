package com.xiaody.spring_boot.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Xiaody on 17/7/19.
 */
public class DemoEvent extends ApplicationEvent {
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

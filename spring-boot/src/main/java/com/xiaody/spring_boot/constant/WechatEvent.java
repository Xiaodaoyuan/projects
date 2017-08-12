package com.xiaody.spring_boot.constant;

/**
 * @Author xiaody
 * @Description
 * @Date create in 17/8/11
 */
public interface WechatEvent {

    /**
     * 关注事件
     */
    String SUBSCRIBE = "subscribe";

    /**
     * 取消关注事件
     */
    String UNSUBSCRIBE = "unsubscribe";

    /**
     * 上报地理位置事件
     */
    String LOCATION = "LOCATION";

    /**
     * 自定义菜单事件
     */
    String CLICK = "CLICK";
}

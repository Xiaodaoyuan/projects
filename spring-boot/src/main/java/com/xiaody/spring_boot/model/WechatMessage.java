package com.xiaody.spring_boot.model;

import com.xiaody.common.utils.CDataAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * @Author xiaody
 * @Description
 * @Date create in 17/8/11
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class WechatMessage implements Serializable {

    /**
     * 消息id，64位整型
     */
    @XmlElement(name = "msgId")
    private Long msgId;

    /**
     * 消息类型
     */
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "MsgType")
    private String msgType;

    /**
     * 开发者微信号
     */
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "ToUserName")
    private String toUserName;

    /**
     * 发送方帐号（一个OpenID）
     */
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "FromUserName")
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    @XmlElement(name = "CreateTime")
    private Long createTime;


    /**
     * 文本消息内容
     */
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "Content")
    private String content;

    /**
     * 图片链接（由系统生成）
     */
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "PicUrl")
    private String picUrl;

    /**
     * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlJavaTypeAdapter(CDataAdapter.class)
    @XmlElement(name = "MediaId")
    private String mediaId;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "WechatMessage{" +
                "msgId=" + msgId +
                ", msgType='" + msgType + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", mediaId='" + mediaId + '\'' +
                '}';
    }
}

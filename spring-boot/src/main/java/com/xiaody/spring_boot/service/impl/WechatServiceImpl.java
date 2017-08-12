package com.xiaody.spring_boot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaody.common.exception.BusinessException;
import com.xiaody.common.utils.FileUtils;
import com.xiaody.common.utils.HttpUtils;
import com.xiaody.common.utils.XmlUtils;
import com.xiaody.spring_boot.constant.WechatMsgType;
import com.xiaody.spring_boot.model.WechatMessage;
import com.xiaody.spring_boot.service.IWechatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.*;

/**
 * @Author xiaody
 * @Description
 * @Date create in 17/8/11
 */
@Service
public class WechatServiceImpl implements IWechatService {

    private static final String WECHAT_TOKEN = "xiaoxiao123";

    private static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    private static final String GENERATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

    private static final String APP_ID = "wx64e6ae7a30100892";

    private static final String APP_SECRET = "a87a7f6ae34790daa095b23496faa993";

    private static final String ACCESS_TOKEN = "accessToken";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 校验微信token
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) throws BusinessException {
        List<String> list = Arrays.asList(WECHAT_TOKEN, timestamp, nonce);
        Collections.sort(list);
        return Objects.equals(shaHex(StringUtils.join(list, "")), signature);
    }

    @Override
    public String handleWechatMessage(WechatMessage message) throws BusinessException {
        WechatMessage toMessage = new WechatMessage();
        toMessage.setCreateTime(message.getCreateTime());
        toMessage.setFromUserName(message.getToUserName());
        toMessage.setMsgType(message.getMsgType());
        toMessage.setToUserName(message.getFromUserName());
        switch (message.getMsgType()) {
            case WechatMsgType.TEXT:
                toMessage.setContent("hello");
                return XmlUtils.convertToXml(toMessage);
            case WechatMsgType.IMAGE:
                toMessage.setMsgType(WechatMsgType.TEXT);
                toMessage.setContent(message.getMediaId());
                return XmlUtils.convertToXml(toMessage);
            default:
                break;
        }
        return null;
    }

    @Override
    public String generateAccessToken() throws BusinessException {
        Map<String, Object> param = new HashMap();
        param.put("grant_type", "client_credential");
        param.put("appid", APP_ID);
        param.put("secret", APP_SECRET);
        String result = HttpUtils.get(GET_ACCESS_TOKEN_URL, param);
        String accessToken = JSON.parseObject(result).getString("access_token");
        stringRedisTemplate.opsForValue().set(ACCESS_TOKEN, accessToken);
        return accessToken;
    }

    @Override
    public String generateMenu() throws BusinessException {
        //构建菜单
        String menuJsonString = FileUtils.readFile(this.getClass().getClassLoader().getResourceAsStream("wechatMenu.json"));
        Map<String, Object> param = (Map) JSONObject.parse(menuJsonString);
        String result = HttpUtils.post(String.format(GENERATE_MENU_URL, stringRedisTemplate.opsForValue().get(ACCESS_TOKEN)), param);
        return result;
    }

    /**
     * sha 加密
     *
     * @param str
     * @return
     */
    private static String shaHex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());
            StringBuffer hexstr = new StringBuffer();
            String shaHex;
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}

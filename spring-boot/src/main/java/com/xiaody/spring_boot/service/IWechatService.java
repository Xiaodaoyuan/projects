package com.xiaody.spring_boot.service;

import com.xiaody.common.exception.BusinessException;
import com.xiaody.spring_boot.model.WechatMessage;

/**
 * @Author xiaody
 * @Description
 * @Date create in 17/8/11
 */
public interface IWechatService {

    boolean checkSignature(String signature, String timestamp, String nonce) throws BusinessException;

    String handleWechatMessage(WechatMessage message)throws BusinessException;

    String generateAccessToken() throws BusinessException;

    String generateMenu() throws BusinessException;
}

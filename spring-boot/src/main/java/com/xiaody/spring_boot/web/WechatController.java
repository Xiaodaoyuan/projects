package com.xiaody.spring_boot.web;

import com.xiaody.common.exception.BusinessException;
import com.xiaody.common.model.ResponseResult;
import com.xiaody.common.utils.XmlUtils;
import com.xiaody.spring_boot.model.WechatMessage;
import com.xiaody.spring_boot.service.IWechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xiaody
 * @Description
 * @Date create in 17/8/10
 */
@RestController
@RequestMapping("/wechat")
public class WechatController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatController.class);

    @Autowired
    private IWechatService wechatService;

    /**
     * 验证接口
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String verify(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce,
                         @RequestParam String echostr) throws BusinessException {
        if (wechatService.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    /**
     * 处理微信消息
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param requestBody
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String handle(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce,
                         @RequestBody String requestBody) throws BusinessException {
        if (wechatService.checkSignature(signature, timestamp, nonce)) {
            WechatMessage message = (WechatMessage) XmlUtils.convertXmlStrToObject(WechatMessage.class, requestBody);
            LOGGER.info("request message:{}", requestBody);
            String returnXml = wechatService.handleWechatMessage(message);
            LOGGER.info("response message:{}", returnXml);
            return returnXml;

        }
        return null;
    }

    @RequestMapping(value = "/generateAccessToken", method = RequestMethod.POST)
    public ResponseResult generateAccessToken() throws BusinessException {
        String accessToken = wechatService.generateAccessToken();
        return new ResponseResult(accessToken);
    }

    @RequestMapping(value = "/generateMenu", method = RequestMethod.POST)
    public ResponseResult generateMenu() throws BusinessException {
        String result = wechatService.generateMenu();
        return new ResponseResult(result);
    }

}

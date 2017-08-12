package com.xiaody.spring_boot.web;

import com.xiaody.common.exception.BusinessException;
import com.xiaody.common.model.ResponseResult;
import com.xiaody.spring_boot.config.WebLog;
import com.xiaody.spring_boot.model.Account;
import com.xiaody.spring_boot.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @SuppressWarnings("unused")
    private Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @WebLog
    public ResponseResult get(@PathVariable Long id, @RequestParam String traceID) throws BusinessException {
        Account account = accountService.get(id);
        return new ResponseResult(traceID, account);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WebLog
    public ResponseResult insert(@RequestParam Account account) throws BusinessException {
        Account account1 = accountService.insert(account);
        return new ResponseResult("", account1);
    }


}

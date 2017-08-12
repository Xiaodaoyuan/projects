package com.xiaody.spring_boot.dao;

import com.xiaody.common.dao.BaseMapper;
import com.xiaody.spring_boot.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper extends BaseMapper<Account> {
}

package com.xiaody.blog.dao;

import com.xiaody.blog.model.Account;
import com.xiaody.blog.model.options.AccountSearchOptions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Xiaody on 2016/9/29.
 */
public interface AccountMapper extends BaseMapper<Account> {

    boolean checkMobileExists(@Param("mobile") String mobile);

    Account checkMobileLogin(@Param("mobile") String mobile, @Param("password") String password);

    List<Account> searchByPage(@Param("options") AccountSearchOptions options);
}

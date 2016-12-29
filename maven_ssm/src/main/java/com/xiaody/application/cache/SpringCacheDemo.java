package com.xiaody.application.cache;

import com.xiaody.application.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


/**
 * Created by Xiaody on 2016/12/21.
 */
@Component
public class SpringCacheDemo {

    @Cacheable(value = "accountCache", condition = "#name.length() <= 12")
    public Account getAccountByName(String name) {
        System.out.println("real querying account " + name);
        Account account = getFromDB(name);
        if (account == null) {
            throw new RuntimeException(String.format("can not find account by account name : [%s]", name));
        }
        return account;
    }

    @Cacheable(value = "accountCache", key = "#name.concat(#mobile)")
    public Account getAccount(String name, String mobile) {
        System.out.println("real querying account... " + name);
        Account account = getFromDB(name, mobile);
        if (account == null) {
            throw new RuntimeException(String.format("can not find account by account name : [%s]", name));
        }
        return account;
    }


    @CacheEvict(value = "accountCache", key = "#account.getUserName()")
    public void updateAccount(Account account) {
        System.out.println("real update db...........");
    }

    @CacheEvict(value = "accountCache", allEntries = true)
    public void reload() {
    }

    private Account getFromDB(String name) {
        System.out.println("real querying account from db " + name);
        Account account = new Account();
        account.setUserName("test spring cache");
        account.setMobile("13718363267");
        return account;
    }

    private Account getFromDB(String name, String mobile) {
        System.out.println("real querying account from db...." + name);
        Account account = new Account();
        account.setUserName(name);
        account.setMobile(mobile);
        return account;
    }
}

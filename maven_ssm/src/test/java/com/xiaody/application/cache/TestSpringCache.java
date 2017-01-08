package com.xiaody.application.cache;

import com.xiaody.application.model.Account;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Xiaody on 2016/12/21.
 */
@ContextConfiguration(locations = {"classpath:application.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringCache {

    @Autowired
    private SpringCacheDemo springCacheDemo;

    @Ignore
    @Test
    public void testSpringCache() {
        System.out.println("first query...");
        Account account = springCacheDemo.getAccountByName("accountName");
        System.out.println(account.getUserName());

        System.out.println("second query...");
        Account account1 = springCacheDemo.getAccountByName("accountName");
        System.out.println(account1.getUserName());

    }

    @Ignore
    @Test
    public void testUpdateSpringCache() {
        System.out.println("first query....");
        Account account = springCacheDemo.getAccountByName("accountName");
        System.out.println(account.getUserName());
        Account account2 = springCacheDemo.getAccountByName("accountName2");
        System.out.println(account2.getUserName());

        account2.setUserName("another spring cache");
        springCacheDemo.updateAccount(account);

        System.out.println("second query....");
        Account account1 = springCacheDemo.getAccountByName("accountName");
        System.out.println(account1.getUserName());
        Account account3 = springCacheDemo.getAccountByName("accountName2");
        System.out.println(account3.getUserName());
    }


    @Ignore
    @Test
    public void testReload() throws Exception {
        springCacheDemo.reload();
        springCacheDemo.getAccountByName("somebody1");
        springCacheDemo.getAccountByName("somebody2");
        System.out.println("-----------------------------");
        springCacheDemo.reload();
        springCacheDemo.getAccountByName("somebody1");
        springCacheDemo.getAccountByName("somebody2");
    }


    @Ignore
    @Test
    public void testSpringCacheByKey() {
        System.out.println("first query...");
        Account account = springCacheDemo.getAccount("accountName", "13718363267");
        System.out.println(account.getUserName());

        System.out.println("second query...");
        Account account1 = springCacheDemo.getAccount("accountName", "13718363267");
        System.out.println(account1.getUserName());
    }
}

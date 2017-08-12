package com.xiaody.spring_boot;

import com.xiaody.common.exception.BusinessException;
import com.xiaody.spring_boot.model.Account;
import com.xiaody.spring_boot.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Key;

/**
 * Created by Xiaody on 17/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTest {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String userName;


    @Test
    public void sendSimpleMail() throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1307120838@qq.com");
        message.setTo("1509111456@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }


    @Test
    public void testShiro() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        //4、登录，即身份验证
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //5、断言用户已经登录
        Assert.assertEquals(true, subject.isAuthenticated());
    }

    @Test
    public void testIsPermission() {
        login("classpath:shiro.ini", "zhang", "123");

        Subject subject = SecurityUtils.getSubject();
        subject.checkRole("role2");
        Assert.assertTrue(subject.hasRole("role1"));
        subject.checkPermission("product:query");
    }

    @Test
    public void testEncrypt() {
        String str = "hello";
//        String encodeStr  = Base64.encodeToString(str.getBytes());
        String encodeStr = Hex.encodeToString(str.getBytes());
        System.out.println(encodeStr);
//        String decodeStr = Base64.decodeToString(encodeStr.getBytes());
        String decodeStr = new String(Hex.decode(encodeStr.getBytes()));
        System.out.println(decodeStr);

        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128);
        Key key = aesCipherService.generateNewKey();

        String encryptStr = aesCipherService.encrypt(str.getBytes(), key.getEncoded()).toHex();
        System.out.println(encryptStr);

    }

    @Autowired
    private AccountService accountService;

    @Test
    public void test() throws BusinessException{
        Account account = accountService.get(1l);
        System.out.println(account);

        Account account1 = new Account();
        account1.setUserName("xiaoxiao");
        account1.setNickName("haha");
        accountService.insert(account1);
        System.out.println(accountService.get(5l));

    }

    private void login(String file, String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(file);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        //4、登录，即身份验证
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

    }
}





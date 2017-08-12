package com.xiaody.spring_boot.shiro.dao;

import com.xiaody.spring_boot.shiro.entity.User;

import java.util.Set;

/**
 * Created by Xiaody on 17/7/12.
 */
public interface IUserDao {
    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}

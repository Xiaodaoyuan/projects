package com.xiaody.mybatis;

/**
 * Created by Xiaody on 2017/3/22.
 */
public interface UserMapper {
    void insertUser(User user);

    User getUserById(Integer id);
}

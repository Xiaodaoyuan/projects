package com.xiaody.blog.service;

/**
 * Created by Xiaody on 2016/9/29.
 */
public interface BaseService<MODEL> {
    MODEL create(MODEL model);

    MODEL update(MODEL model);

    MODEL get(Integer id);

    void delete(Integer id);
}

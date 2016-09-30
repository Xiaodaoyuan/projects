package com.xiaody.blog.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Xiaody on 2016/9/29.
 */
public interface BaseMapper<T> {
    void create(@Param("entity") T entity);

    void update(@Param("entity") T entity);

    T get(@Param("id") Integer id);

    void delete(@Param("id") Integer id);
}

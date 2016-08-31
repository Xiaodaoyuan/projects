package com.xiaody.application.dao;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T> {
    void create(@Param("entity") T entity);

    T get(@Param("id") Integer id);

    void update(@Param("id") Integer id, @Param("entity") T entity);

    void delete(@Param("id") Integer id);
}

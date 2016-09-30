package com.xiaody.blog.service.impl;

import com.xiaody.blog.dao.BaseMapper;
import com.xiaody.blog.model.BaseModel;
import com.xiaody.blog.service.BaseService;
import com.xiaody.blog.util.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Xiaody on 2016/9/29.
 */
public abstract class BaseServiceImpl<MODEL extends BaseModel, MAPPER extends BaseMapper<MODEL>> implements BaseService<MODEL> {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    protected MAPPER mapper;

    @Override
    public MODEL create(MODEL model) {
        CheckUtil.checkNull(model, "entity");
        try {
            mapper.create(model);
        } catch (Exception e) {
            LOGGER.error("Failed to create entity", e);
            throw new RuntimeException(e);
        }
        return model;
    }

    @Override
    public MODEL update(MODEL model) {
        CheckUtil.checkNull(model, "entity");
        if (model.getId() != null) {
            throw new RuntimeException("Missing Entity id.");
        }
        try {
            mapper.update(model);
        } catch (Exception e) {
            LOGGER.error("Failed to update entity", e);
            throw new RuntimeException(e);
        }
        return get(model.getId());
    }

    @Override
    public MODEL get(Integer id) {
        CheckUtil.checkNull(id, "entityId");
        return mapper.get(id);
    }

    @Override
    public void delete(Integer id) {
        CheckUtil.checkNull(id, "entityId");
        try {
            mapper.delete(id);
        } catch (Exception e) {
            LOGGER.error("Failed to delete entity", e);
            throw new RuntimeException(e);
        }
    }
}

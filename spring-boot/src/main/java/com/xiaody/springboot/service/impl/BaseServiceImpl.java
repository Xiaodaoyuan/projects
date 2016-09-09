package com.xiaody.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.springboot.dao.BaseMapper;
import com.xiaody.springboot.model.BaseModel;
import com.xiaody.springboot.service.BaseService;

public abstract class BaseServiceImpl<MODEL extends BaseModel, MAPPER extends BaseMapper<MODEL>> implements BaseService<MODEL> {

	protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected MAPPER mapper;

	@Override
	public MODEL create(MODEL model) {
		mapper.create(model);
		return model;
	}

	@Override
	public MODEL update(MODEL model) {
		mapper.update(model);
		return model;
	}

	@Override
	public MODEL get(Integer id) {
		return mapper.get(id);
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
	}

}

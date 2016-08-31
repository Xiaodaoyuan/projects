package com.xiaody.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xiaody.application.dao.BaseMapper;
import com.xiaody.application.model.BaseModel;
import com.xiaody.application.service.BaseService;
import com.xiaody.application.util.Utils;

public class BaseServiceImpl<MODEL extends BaseModel, MAPPER extends BaseMapper<MODEL>> implements BaseService<MODEL> {
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected MAPPER mapper;

	@Override
	public MODEL create(MODEL model) {
		mapper.create(model);
		return model;
	}

	@Override
	public MODEL update(Integer id, MODEL model) {
		model.setUpdateTime(Utils.now());
		mapper.update(id, model);
		return model;
	}

	@Override
	public void delete(Integer id) {
		mapper.delete(id);
	}

	@Override
	public MODEL get(Integer id) {
		return mapper.get(id);
	}

}

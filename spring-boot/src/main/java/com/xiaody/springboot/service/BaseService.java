package com.xiaody.springboot.service;

import com.xiaody.springboot.model.BaseModel;

public interface BaseService<MODEL extends BaseModel> {

	MODEL create(MODEL model);

	MODEL update(MODEL model);

	MODEL get(Integer id);

	void delete(Integer id);
}

package com.xiaody.application.service;

import com.xiaody.application.model.BaseModel;

public interface BaseService<MODEL extends BaseModel> {
	MODEL create(MODEL model);

	MODEL update(Integer id, MODEL model);

	void delete(Integer id);

	MODEL get(Integer id);
}

package com.xiaody.application.model.cache;

import com.xiaody.application.model.BaseModel;

public class Cache extends BaseModel{
	private Integer id;
	private String cacheKey;
	private String storedValue;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCacheKey() {
		return cacheKey;
	}

	public void setCacheKey(String cacheKey) {
		this.cacheKey = cacheKey;
	}

	public String getStoredValue() {
		return storedValue;
	}

	public void setStoredValue(String storedValue) {
		this.storedValue = storedValue;
	}

}

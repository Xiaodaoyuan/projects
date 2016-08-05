package com.xiaody.application.model.enums;

public enum UserType {
	ADMIN_USER(0),
	GENERAL_USER(1), 
	SILVER_USER(2), 
	GOLD_USER(3),
	DIAMOND_USER(4), 
	ANONYMOUS_USER(5);
	
	private Integer id;

	UserType(Integer id) {
		this.setId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

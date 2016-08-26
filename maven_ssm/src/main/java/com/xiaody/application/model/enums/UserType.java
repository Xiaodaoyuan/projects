package com.xiaody.application.model.enums;

public enum UserType implements Identifiable<Integer> {
	SYSTEM(1),
	COMMON_USER(2),
	SILVER_USER(3),
	GOLD_USER(4),
	DIAMOND_USER(5),
	ANONYMOUS_USER(6);

	private Integer id;

	UserType(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

}

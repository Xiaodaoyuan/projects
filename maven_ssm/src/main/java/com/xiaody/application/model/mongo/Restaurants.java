package com.xiaody.application.model.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="restaurants")
public class Restaurants extends BaseMongoModel {
	private String borough;
	private String cuisine;
	private String name;

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

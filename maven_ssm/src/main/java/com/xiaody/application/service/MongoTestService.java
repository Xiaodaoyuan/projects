package com.xiaody.application.service;

import java.util.List;

import com.xiaody.application.model.mongo.Restaurants;

public interface MongoTestService {
	Restaurants create(Restaurants restaurant);

	Restaurants get(int id);

	List<Restaurants> search();
}

package com.xiaody.application.dao.mongo;

import java.util.List;

import com.xiaody.application.model.mongo.Restaurants;

public class RestaurantsRespository extends BaseMongoRepository<Restaurants> {

	public List<Restaurants> search() {
		return mongoTemplate.findAll(Restaurants.class);
	}
}

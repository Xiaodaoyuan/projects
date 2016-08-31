package com.xiaody.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaody.application.dao.mongo.RestaurantsRespository;
import com.xiaody.application.model.mongo.Restaurants;
import com.xiaody.application.service.MongoTestService;

@Service
public class MongoTestServiceImpl implements MongoTestService {

	@Autowired
	private RestaurantsRespository restaurantsRespository;

	@Override
	public Restaurants create(Restaurants restaurant) {
		restaurantsRespository.create(restaurant);
		return restaurant;
	}

	@Override
	public Restaurants get(int id) {
		return restaurantsRespository.get(id);
	}

	@Override
	public List<Restaurants> search() {
		return restaurantsRespository.search();
	}
}

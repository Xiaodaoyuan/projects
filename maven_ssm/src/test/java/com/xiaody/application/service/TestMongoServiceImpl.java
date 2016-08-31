package com.xiaody.application.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.mongo.Restaurants;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMongoServiceImpl {

	@Autowired
	private MongoTestService mongoTestService;

	@Test
	public void testSearch() {
		List<Restaurants> list = mongoTestService.search();
		System.out.println(list.size());
		System.out.println(list.get(0).getBorough());
	}

}

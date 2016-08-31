package com.xiaody.application.dao.mongo;

import java.lang.reflect.ParameterizedType;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBCollection;
import com.xiaody.application.dao.BaseMapper;
import com.xiaody.application.model.mongo.BaseMongoModel;
import com.xiaody.application.util.Utils;

public class BaseMongoRepository<T extends BaseMongoModel> implements BaseMapper<T> {

	private final static String ID = "_id";

	protected MongoTemplate mongoTemplate;

	protected Class<T> modelClass;
	protected DBCollection collection;

	@SuppressWarnings("unchecked")
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		modelClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(T entity) {
		mongoTemplate.insert(fullEntity(entity));
	}

	@Override
	public T get(Integer id) {
		Query query = new Query().addCriteria(Criteria.where(ID).is(id));
		return mongoTemplate.findOne(query, modelClass);
	}

	@Override
	public void update(Integer id, T entity) {
		throw new RuntimeException("not supported");
	}

	@Override
	public void delete(Integer id) {
		Query query = new Query().addCriteria(Criteria.where(ID).is(id));
		mongoTemplate.findAndRemove(query, modelClass);
	}

	private T fullEntity(T entity) {
		entity.setCreateTime(Utils.now());
		entity.setUpdateTime(Utils.now());
		return entity;
	}
}

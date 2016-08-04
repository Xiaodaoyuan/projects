package com.xiaody.application.cache;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import static com.xiaody.application.util.CommonUtils.*;

public class RedisImpl implements InitializingBean {
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Value("${redis.enabled}")
	private boolean enabled;

	@Value("${redis.host}")
	private String host;

	@Value("${redis.port}")
	private int port;

	@Value("${redis.password}")
	private String password;

	private int dataBase;

	private final String DB_PREFIX = "db";

	private JedisPool pool;

	public RedisImpl() {
		this.dataBase = Protocol.DEFAULT_DATABASE;
	}

	public RedisImpl(int dataBase) {
		this.dataBase = dataBase;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (!enabled) {
			LOGGER.warn("redis cache is disabled!");
			return;
		}
		try {
			JedisPoolConfig config = new JedisPoolConfig();

			pool = new JedisPool(config, host, port, Protocol.DEFAULT_TIMEOUT, password, dataBase, null);
		} catch (Exception e) {
			LOGGER.warn("Error occurred during initializing redis cache client.");
		}
	}

	private Jedis getRedisClient() {
		if (!enabled) {
			LOGGER.warn("redis cache is disabled!");
			return null;
		}
		int no = dataBase;
		if (no < 0 || no > 15) {
			LOGGER.error("Wrong database in redis:" + no);
			return null;
		}
		if (null == pool) {
			LOGGER.error("Init jedis pool failed!");
			return null;
		}
		Jedis jedis = pool.getResource();
		if (null == jedis) {
			LOGGER.error("Failed to get jedis client from the pool!");
			return null;
		}
		return jedis;
	}

	private String getDbKey(String key) {
		int no = dataBase;
		return String.format("%s%d:%s", DB_PREFIX, no, key);
	}

	private void returnResource(Jedis client) {
		if (null == client) {
			return;
		}
		client.close();
	}

	private void returnBrokenResource(Jedis client) {
		if (null == client) {
			return;
		}
		client.close();
	}

	public Set<String> keys(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		Set<String> keys = null;
		try {
			keys = client.keys(key);
		} catch (Exception e) {
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return keys;
	}

	public void strPut(String key, String value) {
		strPut(key, value, 0);
	}

	public void strPut(String key, String value, long expire) {
		Jedis client = getRedisClient();
		if (null == client) {
			return;
		}
		try{
			key =getDbKey(key);
			client.set(key.getBytes(), toBytes(value));
		}catch(Exception e){
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
	}

}

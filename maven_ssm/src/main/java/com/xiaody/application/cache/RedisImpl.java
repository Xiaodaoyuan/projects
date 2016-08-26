package com.xiaody.application.cache;

import static com.xiaody.application.util.Utils.deserialize;
import static com.xiaody.application.util.Utils.serialize;
import static com.xiaody.application.util.Utils.toBytes;
import static com.xiaody.application.util.Utils.toStr;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

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

	//private final String DB_PREFIX = "db";

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

	//private String getDbKey(String key) {
	//	int no = dataBase;
	//	return String.format("%s%d:%s", DB_PREFIX, no, key);
	//}

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

	/**
	 * 
	 * @param key
	 * @return
	 */
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

	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean exist(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return false;
		}
		boolean isExist = false;
		try {
			isExist = client.exists(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis exist: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return isExist;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Long getTTL(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		Long ttl = null;
		try {
			ttl = client.ttl(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis ttl: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return ttl;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Long incr(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		Long incr = null;
		try {
			incr = client.incr(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis incr: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return incr;
	}

	/**
	 * 
	 * @param key
	 * @param num
	 * @return
	 */
	public Long incrby(String key, Long num) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		Long incrby = null;
		try {
			incrby = client.incrBy(key.getBytes(), num);
		} catch (Exception e) {
			LOGGER.error("Error redis incr: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return incrby;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void strPut(String key, String value) {
		strPut(key, value, 0);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 */
	public void strPut(String key, String value, long expire) {
		Jedis client = getRedisClient();
		if (null == client) {
			return;
		}
		try {
			client.set(key.getBytes(), toBytes(value));
			if (expire > 0) {
				client.expireAt(key, expire);
			}
		} catch (Exception e) {
			LOGGER.error("Error redis str put: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String strGet(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		byte[] bytes = null;
		try {
			bytes = client.get(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis str get: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		if (bytes != null) {
			return toStr(bytes);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		put(key, value, 0);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 */
	public void put(String key, Object value, long expire) {
		Jedis client = getRedisClient();
		if (null == client) {
			return;
		}
		try {
			client.set(key.getBytes(), serialize(value));
			if (expire > 0) {
				client.expireAt(key, expire);
			}
		} catch (Exception e) {
			LOGGER.error("Error int redis put: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public <T> T get(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		byte[] bytes = null;
		try {
			bytes = client.get(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis get: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		if (bytes != null) {
			return deserialize(bytes);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void sAdd(String key, Object value) {
		sAdd(key, value, 0);
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param expire
	 */
	public void sAdd(String key, Object value, long expire) {
		Jedis client = getRedisClient();
		if (null == client) {
			return;
		}
		try {
			client.sadd(key.getBytes(), serialize(value));
			if (expire > 0) {
				client.expireAt(key, expire);
			}
		} catch (Exception e) {
			LOGGER.error("Error redis sadd: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public <T> Set<T> sGet(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		Set<byte[]> bytes = null;
		try {
			bytes = client.smembers(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis sget: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		if (bytes != null) {
			Set<T> set = new HashSet<T>();
			for (byte[] bs : bytes) {
				set.add((T) deserialize(bs));
			}
			return set;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param key
	 * @param member
	 */
	public void sRem(String key, Object member) {
		Jedis client = getRedisClient();
		if (null == client) {
			return;
		}
		try {
			client.srem(key.getBytes(), serialize(member));
		} catch (Exception e) {
			LOGGER.error("Error redis srem: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
	}

	/**
	 * 
	 * @param key
	 * @param member
	 * @return
	 */
	public boolean sIsMembers(String key, Object member) {
		Jedis client = getRedisClient();
		if (null == client) {
			return false;
		}
		boolean result = false;
		try {
			result = client.sismember(key.getBytes(), serialize(member));
		} catch (Exception e) {
			LOGGER.error("Error redis sismembers: " + e.getMessage());
			result = false;
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return result;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Long sCard(String key) {
		Jedis client = getRedisClient();
		if (null == client) {
			return null;
		}
		Long result = null;
		try {
			result = client.scard(key.getBytes());
		} catch (Exception e) {
			LOGGER.error("Error redis scard: " + e.getMessage());
			returnBrokenResource(client);
		} finally {
			returnResource(client);
		}
		return result;
	}

}

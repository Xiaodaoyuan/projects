package com.xiaody.application.redis;

import com.xiaody.application.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by Xiaody on 2016/12/30.
 */
@Component
public class SpringRedis {

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    public void put(final String key, Object value) {
        final byte[] valueBytes = Utils.serialize(value);
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(Utils.toBytes(key), valueBytes);
                return null;
            }
        });
    }

    public <T> T get(final String key) {
        return redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyBytes = Utils.toBytes(key);
                if (connection.exists(keyBytes)) {
                    return Utils.deserialize(connection.get(keyBytes));
                }
                return null;
            }
        });
    }

    public void lPush(final String key, final Object value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.lPush(Utils.toBytes(key), Utils.serialize(value));
                return null;
            }
        });

    }

    public void lRange(final String key, final long begin, final long end) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                List<byte[]> l = connection.lRange(Utils.toBytes(key), begin, end);
                return null;
            }
        });
    }

    public void sadd(String key, String value) {
        redisTemplate.opsForSet().add(key, value);
    }

    public Set smembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }
}

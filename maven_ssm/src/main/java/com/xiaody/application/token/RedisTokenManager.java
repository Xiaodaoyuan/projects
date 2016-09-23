package com.xiaody.application.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.xiaody.application.cache.RedisImpl;
import com.xiaody.application.util.Utils;

public class RedisTokenManager implements TokenManager {

	@Value("${token.expireTime}")
	private int expireTime;

	@Autowired
	private RedisImpl redisCache2;

	@Override
	public void createToken() {
		String token = Utils.createUUID();
		if (token == null) {
			throw new RuntimeException("create token error");
		}
		redisCache2.put(token, 1, Utils.nowTime() + expireTime);
	}

	@Override
	public boolean checkToken(String token) {
		boolean result = !StringUtils.isEmpty(token) && redisCache2.exist(token);
		if (result && expireTime > 0) {
			redisCache2.expire(token, expireTime);
		}
		return result;
	}

}

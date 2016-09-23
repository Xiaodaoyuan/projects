package com.xiaody.application.token;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.StringUtils;

import com.xiaody.application.util.Utils;

public class DefaultTokenManager implements TokenManager {

	Map<String, Integer> tokenMap = new ConcurrentHashMap<>();

	@Override
	public void createToken() {
		String token = Utils.createUUID();
		if (token == null) {
			throw new RuntimeException("create token error");
		}
		tokenMap.put(token, 1);
	}

	@Override
	public boolean checkToken(String token) {
		return !StringUtils.isEmpty(token) && tokenMap.containsKey(token);
	}

}

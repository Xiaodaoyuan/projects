package com.xiaody.application.token;

public interface TokenManager {
	void createToken();

	boolean checkToken(String token);
}

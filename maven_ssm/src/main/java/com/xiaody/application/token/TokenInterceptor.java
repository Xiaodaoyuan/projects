package com.xiaody.application.token;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xiaody.application.constant.Constants;

public class TokenInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private TokenManager redisTokenManager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();

		if (method.isAnnotationPresent(IgnoreSecurity.class)) {
			return true;
		}
		String token = request.getHeader(Constants.TOKEN_HEADER);

		if (!redisTokenManager.checkToken(token)) {
			String message = String.format("token [%s] is invalid", token);
			throw new TokenException(message);
		}

		return true;
	}

}

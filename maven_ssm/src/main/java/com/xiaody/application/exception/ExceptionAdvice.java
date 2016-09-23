package com.xiaody.application.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xiaody.application.token.TokenException;

@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {
	private static Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		LOGGER.error("参数解析失败", e);
		return new Response().failure("could_not_read_json");
	}

	/**
	 * 
	 * 401 - Unauthorized
	 * 
	 */
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(TokenException.class)
	public Response handleTokenException(TokenException e) {
		LOGGER.error("令牌验证失败", e);
		return new Response().failure(e.getMessage());
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		LOGGER.error("不支持当前请求方法", e);
		return new Response().failure("request_method_not_supported");
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public Response handleHttpMediaTypeNotSupportedException(Exception e) {
		LOGGER.error("不支持当前媒体类型", e);
		return new Response().failure("content_type_not_supported");
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Response handleException(Exception e) {
		LOGGER.error("服务运行异常", e);
		return new Response().failure(e.getMessage());
	}
}

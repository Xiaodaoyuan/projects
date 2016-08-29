package com.xiaody.application.model.options;

import java.util.Map;

import com.xiaody.application.model.enums.RabbitExchangeType;

public class RMQDeclareExchangeOptions {
	private String exchangeName;
	private RabbitExchangeType exchangeType;
	private Boolean durable = true;
	private Boolean autoDelete = false;
	private Map<String, Object> arguments;

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public RabbitExchangeType getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(RabbitExchangeType exchangeType) {
		this.exchangeType = exchangeType;
	}

	public Boolean getDurable() {
		return durable;
	}

	public void setDurable(Boolean durable) {
		this.durable = durable;
	}

	public Boolean getAutoDelete() {
		return autoDelete;
	}

	public void setAutoDelete(Boolean autoDelete) {
		this.autoDelete = autoDelete;
	}

	public Map<String, Object> getArguments() {
		return arguments;
	}

	public void setArguments(Map<String, Object> arguments) {
		this.arguments = arguments;
	}

}

package com.xiaody.application.model.options;

public class RMQDeclareBindingOptions {

	private String routingKey;

	private RMQDeclareExchangeOptions exchange;

	private RMQDeclareQueueOptions queue;

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public RMQDeclareExchangeOptions getExchange() {
		return exchange;
	}

	public void setExchange(RMQDeclareExchangeOptions exchange) {
		this.exchange = exchange;
	}

	public RMQDeclareQueueOptions getQueue() {
		return queue;
	}

	public void setQueue(RMQDeclareQueueOptions queue) {
		this.queue = queue;
	}

}

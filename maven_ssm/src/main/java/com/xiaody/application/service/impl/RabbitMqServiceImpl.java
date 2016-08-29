package com.xiaody.application.service.impl;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

import com.xiaody.application.model.options.RMQDeclareBindingOptions;
import com.xiaody.application.model.options.RMQDeclareExchangeOptions;
import com.xiaody.application.model.options.RMQDeclareQueueOptions;
import com.xiaody.application.model.options.RMQPublishOptions;
import com.xiaody.application.service.RabbitMqService;

public class RabbitMqServiceImpl implements RabbitMqService {

	@Value("${rabbitmq.enabled}")
	private boolean enabled;

	@Autowired
	private RabbitAdmin admin;
	@Autowired
	private RabbitTemplate template;

	@Override
	public void declareExchange(RMQDeclareExchangeOptions options) {
		if (!enabled) {
			return;
		}
		Assert.notNull(options.getExchangeName(), "RMQ declareExchange exchangeName can not be null");
		Assert.notNull(options.getExchangeType(), "RMQ declareExchange exchangeType can not be null");
		admin.declareExchange(buildExchange(options));
	}

	@Override
	public void declareQueue(RMQDeclareQueueOptions options) {
		if (!enabled) {
			return;
		}
		Assert.notNull(options.getQueueName(), "RMQ declareQueue queueName can not be null");
		Queue queue = new Queue(options.getQueueName(), options.getDurable(), options.getExclusive(),
				options.getAutoDelete(), options.getArguments());
		admin.declareQueue(queue);
	}

	@Override
	public void declareBinding(RMQDeclareBindingOptions options) {
		if (!enabled) {
			return;
		}
		Assert.notNull(options.getRoutingKey(), "RMQ declareBinding routingKey can not be null");
		Exchange exchange = buildExchange(options.getExchange());
		Queue queue = new Queue(options.getQueue().getQueueName(), options.getQueue().getDurable(),
				options.getQueue().getExclusive(), options.getQueue().getAutoDelete(),
				options.getQueue().getArguments());
		admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(options.getRoutingKey()).noargs());
	}

	@Override
	public void declare(RMQDeclareBindingOptions options) {
		if (!enabled) {
			return;
		}
		Exchange exchange = buildExchange(options.getExchange());
		admin.declareExchange(exchange);

		Queue queue = new Queue(options.getQueue().getQueueName(), options.getQueue().getDurable(),
				options.getQueue().getExclusive(), options.getQueue().getAutoDelete(),
				options.getQueue().getArguments());
		admin.declareQueue(queue);

		admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(options.getRoutingKey()).noargs());
	}

	@Override
	public void publish(RMQPublishOptions options) {
		if (!enabled) {
			return;
		}
		Assert.notNull(options.getExchangeName(), "RMQ publish exchangeName can not be null");
		Assert.notNull(options.getMessage(), "RMQ publish message can not be null");
		template.convertAndSend(options.getExchangeName(), options.getRoutingKey(), options.getMessage());
	}

	private Exchange buildExchange(RMQDeclareExchangeOptions options) {
		Exchange exchange;
		switch (options.getExchangeType()) {
		case direct:
			exchange = new DirectExchange(options.getExchangeName(), options.getDurable(), options.getAutoDelete(),
					options.getArguments());
			break;
		case fanout:
			exchange = new FanoutExchange(options.getExchangeName(), options.getDurable(), options.getAutoDelete(),
					options.getArguments());
			break;
		case topic:
			exchange = new TopicExchange(options.getExchangeName(), options.getDurable(), options.getAutoDelete(),
					options.getArguments());
			break;

		default:
			throw new IllegalArgumentException("rabbitMq参数不正确");
		}
		return exchange;
	}

}

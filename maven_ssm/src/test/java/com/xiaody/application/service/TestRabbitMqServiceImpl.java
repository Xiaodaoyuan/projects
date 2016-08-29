package com.xiaody.application.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.enums.RabbitExchangeType;
import com.xiaody.application.model.options.RMQDeclareBindingOptions;
import com.xiaody.application.model.options.RMQDeclareExchangeOptions;
import com.xiaody.application.model.options.RMQDeclareQueueOptions;
import com.xiaody.application.model.options.RMQPublishOptions;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMqServiceImpl {

	@Autowired
	private RabbitMqService rabbitMqService;

	@Ignore
	@Test
	public void testDeclareExchange() {
		RMQDeclareExchangeOptions options = new RMQDeclareExchangeOptions();
		options.setExchangeName("exchange_1");
		options.setExchangeType(RabbitExchangeType.direct);
		rabbitMqService.declareExchange(options);
	}

	@Ignore
	@Test
	public void testDeclareQueue() {
		RMQDeclareQueueOptions options = new RMQDeclareQueueOptions();
		options.setQueueName("queue_1");
		rabbitMqService.declareQueue(options);
	}

	@Ignore
	@Test
	public void testDeclareBinding() {
		RMQDeclareBindingOptions options = new RMQDeclareBindingOptions();
		RMQDeclareExchangeOptions options1 = new RMQDeclareExchangeOptions();
		options1.setExchangeName("exchange_1");
		options1.setExchangeType(RabbitExchangeType.direct);

		RMQDeclareQueueOptions options2 = new RMQDeclareQueueOptions();
		options2.setQueueName("queue_1");

		options.setExchange(options1);
		options.setQueue(options2);
		options.setRoutingKey("routingkey");
		rabbitMqService.declareBinding(options);
	}
	
	@Ignore
	@Test
	public void testDeclare() {
		RMQDeclareBindingOptions options = new RMQDeclareBindingOptions();
		RMQDeclareExchangeOptions options1 = new RMQDeclareExchangeOptions();
		options1.setExchangeName("exchange_1");
		options1.setExchangeType(RabbitExchangeType.direct);

		RMQDeclareQueueOptions options2 = new RMQDeclareQueueOptions();
		options2.setQueueName("queue_1");

		options.setExchange(options1);
		options.setQueue(options2);
		options.setRoutingKey("routingkey");
		rabbitMqService.declare(options);
	}
	
	@Ignore
	@Test
	public void testPublish() {
		RMQPublishOptions options = new RMQPublishOptions();
		options.setRoutingKey("routingkey");
		options.setExchangeName("exchange_1");
		options.setMessage("ha ha !!!!!!!!!!");
		rabbitMqService.publish(options);
	}

}

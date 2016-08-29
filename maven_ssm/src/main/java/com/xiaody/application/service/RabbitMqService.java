package com.xiaody.application.service;

import com.xiaody.application.model.options.RMQDeclareBindingOptions;
import com.xiaody.application.model.options.RMQDeclareExchangeOptions;
import com.xiaody.application.model.options.RMQDeclareQueueOptions;
import com.xiaody.application.model.options.RMQPublishOptions;

public interface RabbitMqService {
	
	void declareExchange(RMQDeclareExchangeOptions options);
	
	void declareQueue(RMQDeclareQueueOptions options);
	
	void declareBinding(RMQDeclareBindingOptions options);
	
	void declare(RMQDeclareBindingOptions options);
	
	void publish(RMQPublishOptions options);

}

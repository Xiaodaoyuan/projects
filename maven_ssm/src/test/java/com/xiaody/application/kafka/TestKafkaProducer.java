package com.xiaody.application.kafka;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaody.application.model.Account;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestKafkaProducer {

	private String topic = "test";

	@Autowired
	private KafkaMessageProducer producer;

//	@Ignore
	@Test
	public void testSend() {
		for (int i = 0; i < 20; i++) {
			Account account = new Account();
			account.setId(i);
			account.setUserName("name" + i);
			producer.send(topic, account);
		}
	}
}

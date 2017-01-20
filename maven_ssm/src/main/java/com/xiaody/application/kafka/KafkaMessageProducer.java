package com.xiaody.application.kafka;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class KafkaMessageProducer {

	@Value("${kafka.bootstrap.servers}")
	private String bootstrapServers;

	private Producer<String, String> producer = null;

	@PostConstruct
	public void init() {
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<>(properties);
	}

	@PreDestroy
	public void destroy() {
		if (producer != null) {
			producer.close();
		}
	}

    public void send(String topic, Object object) {
        if (null == producer)
            return;
        String value = JSON.toJSONString(object);
        ProducerRecord<String, String> record = new ProducerRecord<>(topic,  value);
        producer.send(record);
    }
}

package com.xiaody.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

//import java.util.Optional;


/**
 * Created by Xiaody on 2017/1/19.
 */
public class Listener {

    @KafkaListener(topics = {"bupt"})
    public void listen(ConsumerRecord<?, ?> record) {
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//        if (kafkaMessage.isPresent()) {
//            Object message = kafkaMessage.get();
//            System.out.println("listen1 " + message);
//        }
        System.out.println("listen1 " +record.key());
        System.out.println("listen1 " +record.value());
    }
}

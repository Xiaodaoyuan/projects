package com.xiaody.service;

/**
 * Created by Xiaody on 2017/1/20.
 */
public interface IKafkaService {

    void send(String topic, Object data);

    void send(String topic, Object key, Object data);

    void send(String topic, int partition, Object data);


    void send(String topic, int partition, Object key, Object data);
}

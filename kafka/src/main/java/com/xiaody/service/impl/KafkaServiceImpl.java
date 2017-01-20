package com.xiaody.service.impl;

import com.xiaody.service.IKafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Xiaody on 2017/1/20.
 */
@Service
public class KafkaServiceImpl implements IKafkaService {


    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send(String topic, Object data) {
        this.send(topic, null, data);
    }

    @Override
    public void send(String topic, Object key, Object data) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, key, data);
        Map m = checkProRecord(result);
        System.out.println(m.get("code"));
        System.out.println(m.get("message"));
    }

    @Override
    public void send(String topic, int partition, Object data) {
        this.send(topic, partition, null, data);
    }

    @Override
    public void send(String topic, int partition, Object key, Object data) {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, partition, key, data);
        Map m = checkProRecord(result);
        System.out.println(m.get("code"));
        System.out.println(m.get("message"));
    }


    /**
     * 检查发送返回结果record
     *
     * @param res
     * @return
     */
    @SuppressWarnings("rawtypes")
    private Map<String, Object> checkProRecord(ListenableFuture<SendResult<String, String>> res) {
        Map<String, Object> m = new HashMap<>();
        if (res != null) {
            try {
                SendResult r = res.get();//检查result结果集
                /*检查recordMetadata的offset数据，不检查producerRecord*/
                Long offsetIndex = r.getRecordMetadata().offset();
                if (offsetIndex != null && offsetIndex >= 0) {
                    m.put("code", "SUCCESS_CODE");
                    m.put("message", "SUCCESS_MES");
                    return m;
                } else {
                    m.put("code", "KAFKA_NO_OFFSET_CODE");
                    m.put("message", "KAFKA_NO_OFFSET_MES");
                    return m;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                m.put("code", "KAFKA_SEND_ERROR_CODE");
                m.put("message", "KAFKA_SEND_ERROR_MES");
                return m;
            } catch (ExecutionException e) {
                e.printStackTrace();
                m.put("code", "KAFKA_SEND_ERROR_CODE");
                m.put("message", "KAFKA_SEND_ERROR_MES");
                return m;
            }
        } else {
            m.put("code", "KAFKA_NO_RESULT_CODE");
            m.put("message", "KAFKA_NO_RESULT_MES");
            return m;
        }
    }
}

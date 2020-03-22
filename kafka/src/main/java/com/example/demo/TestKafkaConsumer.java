package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * test kafka consumer
 */
@Component
public class TestKafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println(String.format("topic:%s,offset:%d,value:%s"
                , record.topic()
                , record.offset()
                , record.value()));
    }
}

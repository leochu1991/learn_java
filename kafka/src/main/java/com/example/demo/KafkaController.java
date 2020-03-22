package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * kafka controller
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * http://localhost:8080/kafka/sendMsg?topic=test&msg=hello
     *
     * @param topic
     * @param msg
     * @return
     */
    @RequestMapping("/sendMsg")
    public String sendMsg(String topic, String msg) {
        kafkaTemplate.send(topic, msg);
        return String.format("topic:%s,msg:%s"
                , topic
                , msg);
    }
}

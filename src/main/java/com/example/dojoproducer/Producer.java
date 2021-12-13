package com.example.dojoproducer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Value("${topic}")
    private String TOPIC_DOJO;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String msg){
        kafkaTemplate.send(TOPIC_DOJO, msg);
        System.out.println("message sent :" + msg + " - to - " + TOPIC_DOJO);
    }
}

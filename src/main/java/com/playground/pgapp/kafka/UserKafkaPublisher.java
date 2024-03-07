package com.playground.pgapp.kafka;

import com.playground.pgapp.transactional.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaPublisher {
    private final String TOPIC = "test-topic";
    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserKafkaPublisher(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(User user) {
        kafkaTemplate.send(TOPIC, user);
    }
}

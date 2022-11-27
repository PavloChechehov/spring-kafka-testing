package com.example;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> template;
    private final NewTopic topic;

    public void send(String message) {
        template.send(topic.name(), message);
    }

    public void send(String topic, String data) {
        template.send(topic, data);
    }
}

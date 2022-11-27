package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GreetingController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/greeting")
    public void greeting(@RequestBody String greeting) {

        log.info("Post method, greeting = {}", greeting);

        kafkaProducer.send(greeting);

    }
}

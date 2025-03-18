package com.practice.beta.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Setter
@ConfigurationProperties(prefix = "rabbit")
public class MessageSender {

    private String queueName;

    private final AmqpTemplate amqpTemplate;

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend(queueName, message);
        log.info("Message sent");
    }

}

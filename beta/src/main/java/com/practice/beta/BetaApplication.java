package com.practice.beta;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BetaApplication {

    private final RabbitAdmin rabbitAdmin;
    private final Queue queue;

    @PostConstruct
    public void declareQueues() {
        rabbitAdmin.declareQueue(queue);
    }

    public static void main(String[] args) {
        SpringApplication.run(BetaApplication.class, args);
    }

}

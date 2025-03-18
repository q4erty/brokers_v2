package com.practice.beta.controller;

import com.practice.beta.service.impl.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbit")
@RequiredArgsConstructor
public class RabbitController {

    private final MessageSender messageSender;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {

        if (message.isBlank()) return new ResponseEntity<>(message, HttpStatus.valueOf(400));

        messageSender.sendMessage(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}

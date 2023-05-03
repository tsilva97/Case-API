package com.example.demo.controllers;

import com.example.demo.models.Message;
import com.example.demo.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    KafkaProducerService kafkaProducer;
    @PostMapping("/message")
    public String sendMessage(@RequestBody Message message){
        String recipient = message.getRecipient();
        kafkaProducer.sendMessage(recipient, message);
        return "Message sent succesfully";
    }
}

package com.example.demo.services;

import com.example.demo.models.Message;
import com.example.demo.models.Models;
import com.example.demo.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Models> kafkaTemplate;

    private String kafkaTopicLocation = "device-location";
    private String kafkaTopicMessage = "messages";
    public void sendMessage(String recipient, Message message) {
        kafkaTemplate.send(kafkaTopicMessage, recipient, message);
    }

    public void deletePosition(String deviceId) {
        kafkaTemplate.send(kafkaTopicLocation, deviceId, null);
    }

    public void sendPosition(String deviceId, Position position ) {
        kafkaTemplate.send(kafkaTopicLocation, deviceId, position);
    }


}

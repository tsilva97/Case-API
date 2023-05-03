package com.example.demo.controllers;

import com.example.demo.controllers.structs.DeletePositionRequestBody;
import com.example.demo.controllers.structs.SendPositionRequestBody;
import com.example.demo.models.Position;
import com.example.demo.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    @Autowired
    KafkaProducerService kafkaProducer;
    @PostMapping("/position")
    public String sendPosition(@RequestBody SendPositionRequestBody body){

        Position position = new Position(body.getX(), body.getY(), body.getZ());
        kafkaProducer.sendPosition(body.getDeviceId(), position);
        return "Position sent succesfully";
    }
    @DeleteMapping("/position")
    public String deletePosition(@RequestBody DeletePositionRequestBody body){

        kafkaProducer.deletePosition(body.getDeviceId());
        return "Position deleted succesfully";
    }
}

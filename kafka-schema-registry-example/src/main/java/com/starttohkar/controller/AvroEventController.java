package com.starttohkar.controller;

import com.starttohkar.dto.Employee;
import com.starttohkar.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvroEventController {

    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/avroevents")
    public String sendMessage(@RequestBody Employee employee){
        producer.send(employee);
        return "Message published...!!!";
    }
}

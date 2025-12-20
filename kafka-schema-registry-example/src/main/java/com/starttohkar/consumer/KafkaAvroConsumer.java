package com.starttohkar.consumer;

import com.starttohkar.dto.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroConsumer {

    Logger log = LoggerFactory.getLogger(KafkaAvroConsumer.class);

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Employee> consumerRecord){
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();
        log.info("Avro Message received for key :- " + key + " with value :- " + employee.toString());


    }

}

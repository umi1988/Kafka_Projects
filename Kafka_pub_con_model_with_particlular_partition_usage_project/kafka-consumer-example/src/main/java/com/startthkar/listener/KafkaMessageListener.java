package com.startthkar.listener;

import com.startthkar.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    //This one we are using for this example
    @KafkaListener(topics = "mySixthtopic" , groupId = "KafkaGroup-4",
            topicPartitions = {@TopicPartition(topic = "mySixthtopic", partitions = {"2"})})
    public void consume(String receiver){
        log.info("Consumer consume the message {} ", receiver);
    }

    @KafkaListener(topics = "myfifthtopic" , groupId = "KafkaGroup-5")
    public void consumeEvents(Customer customer){
        log.info("Consumer consume the Events {} ", customer.toString());
    }
}

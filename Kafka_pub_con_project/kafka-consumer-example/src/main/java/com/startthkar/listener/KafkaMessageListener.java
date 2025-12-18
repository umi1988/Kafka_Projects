package com.startthkar.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "myfourthtopic" , groupId = "KafkaGroup-4")
    public void consume(String receiver){
        log.info("Consumer consume the message {} ", receiver);
    }
}

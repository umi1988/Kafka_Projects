package com.startthkar.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createNewTopic(){
        return new NewTopic("myfifthtopic", 5, (short) 1);
    }
}

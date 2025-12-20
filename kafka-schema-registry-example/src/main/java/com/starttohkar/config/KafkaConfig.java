package com.starttohkar.config;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Value("${topic.name}")
    private String topicName;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(topicName,3,(short) 1);
    }

    @PostConstruct
    public void logConfig() {
        System.out.println("Bootstrap servers: " + kafkaProperties.getBootstrapServers());
    }
}

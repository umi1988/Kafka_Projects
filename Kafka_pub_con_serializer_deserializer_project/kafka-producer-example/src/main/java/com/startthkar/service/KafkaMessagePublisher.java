package com.startthkar.service;

import com.startthkar.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sentMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("myfourthtopic", message);
        future.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("Sent Message =[" + message + "] with offset =[" + result.getRecordMetadata().offset() + "]");
            }else{
                System.out.println("Unable to Sent Message =[" + message + "] due to : " + ex.getMessage());
            }
        });
    }


    public void sentEventsToTopic(Customer customer){
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("myfifthtopic", customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent Message =[" + customer.toString() + "] with offset =[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to Sent Message =[" + customer.toString() + "] due to : " + ex.getMessage());
                }
            });
        }catch (Exception e){
            System.out.println("ERROR - " + e.getMessage());
        }
    }
}

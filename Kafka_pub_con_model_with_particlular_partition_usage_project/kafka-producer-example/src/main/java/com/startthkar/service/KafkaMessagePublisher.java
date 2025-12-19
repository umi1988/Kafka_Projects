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

    // This one we are using for this example as we are checking like publisher will publish the message to
    // particular kafka partition. we are publishing the hard coded message, not from the api call, but we need to
    // make a api call with dummy string
    public void sentMessageToTopic(String message){
//        CompletableFuture<SendResult<String, Object>> future = template.send("myfourthtopic", message);
//        future.whenComplete((result,ex)->{
//            if(ex == null){
//                System.out.println("Sent Message =[" + message + "] with offset =[" + result.getRecordMetadata().offset() + "]");
//            }else{
//                System.out.println("Unable to Sent Message =[" + message + "] due to : " + ex.getMessage());
//            }
//        });
        template.send("mySixthtopic", 0, null, "User 1 Hi");
        template.send("mySixthtopic", 1, null, "User 2 Hello Sir");
        template.send("mySixthtopic", 1, null,"User 2 How are you.");
        template.send("mySixthtopic", 1, null,"User 2 Welcome to India");
        template.send("mySixthtopic", 2, null,"Guest Thank You");
        template.send("mySixthtopic", 2, null,"Guest Appreciated");

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

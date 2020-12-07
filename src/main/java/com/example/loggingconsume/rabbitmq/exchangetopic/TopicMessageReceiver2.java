package com.example.loggingconsume.rabbitmq.exchangetopic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicMessageReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicMessageReceiver2  : " +msg);
    }

}

package com.example.loggingconsume.rabbitmq.tansferjsonbean;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
@RabbitListener(queues = "json")
public class JsonReceiver {

    @RabbitHandler
    public void process(JSONObject jsonobject) {
        System.out.println("jsonobject receive  : " + jsonobject);
    }

}
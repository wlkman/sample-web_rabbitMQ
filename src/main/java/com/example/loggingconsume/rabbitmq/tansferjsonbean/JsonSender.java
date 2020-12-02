package com.example.loggingconsume.rabbitmq.tansferjsonbean;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class JsonSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
    	JSONObject object = new JSONObject();
        //string
        object.put("string","string");
        //int
        object.put("int",2);
        //boolean
        object.put("boolean",true);
        //array
//        List<Integer> integers = Arrays.asList(1,2,3);
//        object.put("list",integers);
        //null
        object.put("null",null);
//    ​
//        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend("json", object);
    }

}

package com.example.loggingconsume.rabbitmq.tansferbean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

@Component
public class UserSenderSSL {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;
	 @Resource(name="secondRabbitTemplate")
	 private RabbitTemplate secondRabbitTemplate;

    public void send() {
    	JSONObject object = new JSONObject();
        //string
        object.put("string","string");
        //int
        object.put("int",66);
        //boolean
        object.put("boolean",true);
        //null
        object.put("null",null);
        
        //token
        object.put("token","eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiY2FzLWRldiIsImVtYWlsLXNlcnZpY2UtZGV2IiwiYXBpZ2F0ZXdheS1kZXYiLCJjb25zZW50LWRldiIsImNwZHNIaXN0b3J5U2VydmljZS1kZXYiLCJlYXMtZGV2IiwiY3Bkcy11c2VyLXByb2ZpbGUtZGV2IiwiY3Bkcy13b3JrZmxvdy1zZXJ2aWNlLWRldiJdLCJzY29wZSI6WyJjYXMtYWRtaW4iLCJjYXMtbWFuYWdlIiwiY2FzLXJlYWQiLCJ3b3JrZmxvd19jb25zdW1lciIsImVhcy1nZXQiLCJlYXMtcG9zdCIsImVtYWlsX21hbmFnZXIiLCJlbWFpbF9jb25zdW1lciIsImhpc3RvcnlfY29uc3VtZXIiXSwiZXhwIjoxNjE1NjIxMzgwLCJqdGkiOiIzYjgyYzg3Yy1hN2I0LTRiMTktOWM1My05YzQwMGIyNzlhYTUiLCJjbGllbnRfaWQiOiJwcHBwLWNvbW1vbnMtZGV2In0.DKCqfa0bqKhk7_RzBnhtHHw6wDrLsHXZtg0m4wgvrVHhgUumYGDobL8nc-hAiFQxYK6398-XOlXGC5pXgHf6qKvJwL10oaQBASGN-8zBJHx9Rv6AhaKUD6eOeG2W_0kN2odWy9P8z6xzCfqwFlsGz71FeUaeTNoi3ANsQfCTDxI");

        this.secondRabbitTemplate.convertAndSend("historyExchange", "topic.createHistory", object);
    }

}

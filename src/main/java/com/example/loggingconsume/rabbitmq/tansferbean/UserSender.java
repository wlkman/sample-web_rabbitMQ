package com.example.loggingconsume.rabbitmq.tansferbean;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;
	
	 @Resource(name="firstRabbitTemplate")
	 private RabbitTemplate firstRabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("hzb");
        user.setPass("123456789");
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.firstRabbitTemplate.convertAndSend("user", user);
    }

}

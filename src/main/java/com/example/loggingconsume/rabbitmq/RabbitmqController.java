package com.example.loggingconsume.rabbitmq;

//import com.example.loggingconsume.rabbitmq.callback.CallBackSender;
import com.example.loggingconsume.rabbitmq.demohello.HelloSender1;
import com.example.loggingconsume.rabbitmq.exchangebroadcast.FanoutSender;
import com.example.loggingconsume.rabbitmq.mutiproductormuticonsumer.MutiproductormuticonsumerSender1;
import com.example.loggingconsume.rabbitmq.mutiproductormuticonsumer.MutiproductormuticonsumerSender2;
import com.example.loggingconsume.rabbitmq.singleproductormuticonsumer.SingleproductormuticonsumerSender1;
import com.example.loggingconsume.rabbitmq.tansferbean.UserSender;
import com.example.loggingconsume.rabbitmq.tansferbean.UserSenderSSL;
import com.example.loggingconsume.rabbitmq.tansferjsonbean.JsonSender;
import com.example.loggingconsume.rabbitmq.exchangetopic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitmqController {

    @Autowired
    private HelloSender1 helloSender;

    @Autowired
    private SingleproductormuticonsumerSender1 singleproductormuticonsumerSender1;

    @Autowired
    private MutiproductormuticonsumerSender1 mutiproductormuticonsumerSender1;

    @Autowired
    private MutiproductormuticonsumerSender2 mutiproductormuticonsumerSender2;

    @Autowired
    UserSender userSender;

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutSender;
    
    @Autowired
    UserSenderSSL userSenderSSL;

//    @Autowired
//    CallBackSender callBackSender;
    
    @Autowired
    JsonSender jsonSender;

    /**
     * 单生产者-单消费者
     */
    @GetMapping("/hello")
    public void hellopost() {
        helloSender.send();
    }

    /**
     * 单生产者-多消费者
     */
    @GetMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            singleproductormuticonsumerSender1.send("oneToMany:"+i);
        }

    }

    /**
     * 多生产者-多消费者
     */
    @GetMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            mutiproductormuticonsumerSender1.send("manyToMany:"+i);
            mutiproductormuticonsumerSender2.send("manyToMany:"+i);
        }

    }

    /**
     * 实体类传输测试
     */
    @GetMapping("/userTest")
    public void userTest() {
//        userSender.send();
        userSenderSSL.send();
    }


    /**
     * topic exchange类型rabbitmq测试
     */
    @GetMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }


    /**
     * fanout exchange类型rabbitmq测试
     */
    @GetMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }


//    @GetMapping("/callback")
//    public void callbak() {
//        callBackSender.send();
//    }
    
    @GetMapping("/json")
    public void jsonpost() {
    	jsonSender.send();
    }

}
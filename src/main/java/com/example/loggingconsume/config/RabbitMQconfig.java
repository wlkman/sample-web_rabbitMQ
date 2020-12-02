package com.example.loggingconsume.config;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQconfig {
	
//	touny.rabbitmq.host=6e4a1d1c-2de3-470d-b40c-233ac59d640c.bn2a2vgd01r3l0hfmvc0.databases.appdomain.cloud
//			touny.rabbitmq.port=30159
//			touny.rabbitmq.username=chistory
//			touny.rabbitmq.password=!QAZ123
//			touny.rabbitmq.virtual-host=cpds.cs.history
	
//	@Value("${touny.rabbitmq.host}")
//	private String host;
//	
//	@Value("${touny.rabbitmq.port}")
//	private int port;
//	
//	@Value("${touny.rabbitmq.username}")
//	private String username;
//	
//	@Value("${touny.rabbitmq.password}")
//	private String password;
//	
//	@Value("${touny.rabbitmq.virtual-host}")
//	private String virtualhost;
	
//	@Bean
//	public ConnectionFactory connectionFactory() throws Exception {
//		ConnectionFactory factory = new ConnectionFactory();
////        factory.setHost(host);
////        factory.setPort(port);
////        factory.setPassword(password);
////        factory.setUsername(username);
////        factory.setVirtualHost(virtualhost);
////        factory.setHost("localhost");
////        factory.setPort(5672);
////        factory.setPassword("admin");
////        factory.setUsername("admin");
////        factory.setVirtualHost("testVirtualHost");
//		factory.setHost("6e4a1d1c-2de3-470d-b40c-233ac59d640c.bn2a2vgd01r3l0hfmvc0.databases.appdomain.cloud");
//        factory.setPort(30159);
//        factory.setPassword("!QAZ123");
//        factory.setUsername("chistory");
//        factory.setVirtualHost("cpds.cs.history");
//        
//
//        factory.useSslProtocol();
//        return factory;
//		
//	}

}

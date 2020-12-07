package com.example.loggingconsume.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.AbstractConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;

@Configuration
public class RabbitMQconfig {
	
		@Bean(name = "firstConnectionFactory")
	    @Primary
	    public ConnectionFactory firstConnectionFactory(
	            @Value("${spring.rabbitmq.first.host}") String host,
	            @Value("${spring.rabbitmq.first.port}") int port,
	            @Value("${spring.rabbitmq.first.username}") String username,
	            @Value("${spring.rabbitmq.first.password}") String password,
	            @Value("${spring.rabbitmq.first.virtual-host}") String virtualHost
	    ) {
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
	        connectionFactory.setHost(host);
	        connectionFactory.setPort(port);
	        connectionFactory.setUsername(username);
	        connectionFactory.setPassword(password);
	        connectionFactory.setVirtualHost(virtualHost);
	        return connectionFactory;
	    }

	    @Bean(name = "secondConnectionFactory")
	    public ConnectionFactory secondConnectionFactory(
	            @Value("${spring.rabbitmq.second.uri}") String uri,
	            @Value("${spring.rabbitmq.second.virtual-host}") String virtualHost
	    ) {
	        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
	        connectionFactory.setUri(uri);
	        connectionFactory.setVirtualHost(virtualHost);
	        return connectionFactory;
	    }

	    @Bean(name = "firstRabbitTemplate")
	    @Primary
	    public RabbitTemplate firstRabbitTemplate(
	            @Qualifier("firstConnectionFactory") ConnectionFactory connectionFactory
	    ) {
	        RabbitTemplate firstRabbitTemplate = new RabbitTemplate(connectionFactory);
	        return firstRabbitTemplate;
	    }

	    @Bean(name = "secondRabbitTemplate")
	    public RabbitTemplate secondRabbitTemplate(
	            @Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory
	    ) {
	        RabbitTemplate secondRabbitTemplate = new RabbitTemplate(connectionFactory);
	        return secondRabbitTemplate;
	    }

	   

}

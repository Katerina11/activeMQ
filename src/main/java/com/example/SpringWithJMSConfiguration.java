package com.example;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class SpringWithJMSConfiguration {

	@Bean
	ConnectionFactory connectionFactory() {		
		ActiveMQConnectionFactory activeMQconnectionFactory = new ActiveMQConnectionFactory();
		activeMQconnectionFactory.setBrokerURL("tcp://localhost:61616");
		activeMQconnectionFactory.setTrustAllPackages(true);
		activeMQconnectionFactory.setUseAsyncSend(true);
		 
		CachingConnectionFactory cachingConnectionFactory= new CachingConnectionFactory(activeMQconnectionFactory);
		return cachingConnectionFactory;
	}

	@Bean
	ActiveMQQueue messageDestination() {
		return new ActiveMQQueue("messageQueue1");
	}

		
	
	@Bean
	JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		jmsTemplate.setReceiveTimeout(1000);
		return jmsTemplate;
	}

	@Bean
	SpringJmsConsumer springJmsConsumer() {
		SpringJmsConsumer springJmsConsumer = new SpringJmsConsumer();
		springJmsConsumer.setDestination(messageDestination());
		springJmsConsumer.setJmsTemplate(jmsTemplate());
		return springJmsConsumer;
	}

	@Bean
	SpringJmsProducer springJmsProducer() {
		SpringJmsProducer springJmsProducer = new SpringJmsProducer();
		springJmsProducer.setDestination(messageDestination());
		springJmsProducer.setJmsTemplate(jmsTemplate());		
		return springJmsProducer;
	}
	String prefetch="?jms.prefetchPolicy.queuePrefetch=2";
}

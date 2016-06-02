package com.example;

import java.net.URI;
//import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
//import org.apache.activemq.broker.BrokerFactory;
//import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class JmStemplateWithSpringApplication {

	public static void main(String[] args) throws URISyntaxException, Exception {
		// ConfigurableApplicationContext se koristi koga sakam da imam kontrola
		// vrz celiot life cycle na aplikacijata, a ApplicationContext koga
		// sakam da imam samo pristap do bean-ovite

		ConfigurableApplicationContext ctx = SpringApplication.run(JmStemplateWithSpringApplication.class, args);
		/*BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		broker.start();*/

		try {
			/*SpringJmsProducer springJmsProducer = (SpringJmsProducer) ctx.getBean("springJmsProducer");
			springJmsProducer.sendMessage("sending...1");
			springJmsProducer.sendMessage("sending...2");
			springJmsProducer.sendMessage("sending...3");
			springJmsProducer.sendMessage("sending...4");
			SpringJmsConsumer springJmsConsumer = (SpringJmsConsumer) ctx.getBean("springJmsConsumer");
			System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
			System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
		System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
			System.out.println("Consumer receives " + springJmsConsumer.receiveMessage()); */

		} finally {
			// broker.stop();
			/*ctx.stop();*/

		}

	}

}

package com.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import demo.LivingThing;
import demo.Person;

@Component
public class Consumer {

	@JmsListener(destination = "sample.demoActiveMQ1")
	@SendTo("sample.JMStemplateWithSpring")
	public String receiveQueue(String text) {
		System.out.println(
				"Consumer from JMStemplateWithSpring received " + text + " and sent to sample.JMStemplateWithSpring");
		return text+" sent from JMStemplateWithSpring";
	}

	@JmsListener(destination = "sample.demoActiveMQ2")
	public void receiveObject(Person person) {
		System.out.println("Consumer from JMStemplateWithSpring received person object: " +person.getName() + " "
				+ person.getSurname()+ " "+person.getYears());
	}

}
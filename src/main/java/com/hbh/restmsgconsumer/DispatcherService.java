package com.hbh.restmsgconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class DispatcherService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${jms.queue2}")
    String jmsQueue;

    public void sendMessage(String message){
        //jmsTemplate.convertAndSend(jmsQueue, message);
    	jmsTemplate.setPubSubDomain(true);
        jmsTemplate.convertAndSend(jmsQueue, message, m -> {
        	m.setStringProperty("name", "aardvark");
        	m.setStringProperty("hat", "green");
        	return m;
        });
    }
}

package com.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * created by drsantos on 19-04-2017
 */

public class MockEmailService extends AbstractEmailService {
	
	
	private static final Logger log = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendGenericEmailMessage(SimpleMailMessage message) {
		log.debug("Simulating an email service...");
		log.info(message.toString());
		log.debug("Email sent.");
	}

}

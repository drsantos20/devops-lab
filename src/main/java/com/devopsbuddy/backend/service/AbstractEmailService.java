package com.devopsbuddy.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.devopsbuddy.web.domain.FeedbackPojo;

/**
 * created by drsantos on 19-04-2017
 */

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.to.address}")
	private String defaultToAddress;
	
	protected SimpleMailMessage prepareSimpleMessageFromFeedbackPojo(FeedbackPojo feedbackPojo) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(defaultToAddress);
		message.setFrom(feedbackPojo.getEmail());
		message.setSubject("[DevOps]: Feedback received from " + feedbackPojo.getFirstName() + " " +
		feedbackPojo.getLastName() + "!");
		message.setText(feedbackPojo.getFeedback());
		return message;
	}
	
	@Override
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
		sendGenericEmailMessage(prepareSimpleMessageFromFeedbackPojo(feedbackPojo));
	}
}

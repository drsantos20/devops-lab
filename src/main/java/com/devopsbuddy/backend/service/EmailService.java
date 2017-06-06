package com.devopsbuddy.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.devopsbuddy.web.domain.FeedbackPojo;

/**
 * created by drsantos on 19-04-2017
 */

public interface EmailService {
	
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo);
	
	public void sendGenericEmailMessage(SimpleMailMessage message);

}

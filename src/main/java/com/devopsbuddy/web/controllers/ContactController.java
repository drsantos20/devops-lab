package com.devopsbuddy.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.web.domain.FeedbackPojo;

/**
 * created by drsantos on 19-04-2017
 */

@Controller
public class ContactController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);

	
	/* The key which identifies the feedback payload in the Model*/
	public static final String FEEDBACK_MODEL_KEY = "feedback";
	
	/* The contact us view name for testing integration*/
	public static final String CONTACT_US_VIEW_NAME = "contact/contact";

	/* The contact us view name for testing integration*/
	public static final String CONTACT_US_SUCCESS_VIEW_NAME = "contact/success";
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactGet(ModelMap model) {
		FeedbackPojo feedbackPojo = new FeedbackPojo();
		model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
		return ContactController.CONTACT_US_VIEW_NAME;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback) {
		log.debug("Feedback POJO content {}", feedback);
		emailService.sendFeedbackEmail(feedback);
		return ContactController.CONTACT_US_SUCCESS_VIEW_NAME;
	}

}

package com.devopsbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.SmtpEmailService;

/**
 * created by drsantos on 19-04-2017
 */

@Configuration 
@Profile("prod")
@PropertySource("file:///${user.home}/Documents/dev/application-prod.properties")
public class ProductionConfig {
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}

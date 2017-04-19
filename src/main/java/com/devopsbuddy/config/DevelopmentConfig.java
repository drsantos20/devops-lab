package com.devopsbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.MockEmailService;

/**
 * created by drsantos on 19-04-2017
 */

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/Documentos/dev/application-dev.properties")
public class DevelopmentConfig {
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}

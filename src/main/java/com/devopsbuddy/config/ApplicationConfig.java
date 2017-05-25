package com.devopsbuddy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * created by drsantos on 24-04-2017
 */

@Configuration
@EnableJpaRepositories(basePackages="com.devopsbuddy.backend.persistence.repositories")
@EntityScan(basePackages = "com.devopsbuddy.backend.persistence.domain.backend")
@EnableTransactionManagement //transcation management
@PropertySource("file:///${user.home}/Documents/dev/application-common.properties")
public class ApplicationConfig {
	
	@Value("{aws.accessKey}")
	private String accessKey;
	
	@Value("{aws.privateKey}")
	private String privateKey;
	
	
	/*
	 * Create a client for aws amazon 
	 */
	
	@Bean
	public AmazonS3 s3Client() {
		
		BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, privateKey); 
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).build();
		return s3Client;
	}

}

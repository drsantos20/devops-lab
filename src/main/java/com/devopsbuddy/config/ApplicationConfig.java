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
	
//	@Value("{aws.s3.profile}")
//	private String awsProfileName;
	
	/*
	 * Create a client for aws amazon 
	 */
	
	@Bean
	public AmazonS3 s3Client() {
		
		BasicAWSCredentials creds = new BasicAWSCredentials("AKIAJFN7Y3RJ3KXRHICQ", "gy73W+rUgZrnFELqC1OPA/6T+SqVtNkSRVmBkY7o"); 
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(creds)).build();
		
		return s3Client;
		
		/*
		AWSCredentials credentials = new ProfileCredentialsProvider(awsProfileName).getCredentials();
		AmazonS3Client s3Client = new AmazonS3Client(credentials);
		
		//http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/using-regions-availability-zones.html
		Region region = Region.getRegion(Regions.SA_EAST_1);
		s3Client.setRegion(region);
		return s3Client;
		
		*/
	}

}

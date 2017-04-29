package com.devopsbuddy.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * created by drsantos on 24-04-2017
 */

@Configuration
@EnableJpaRepositories(basePackages="com.devopsbuddy.backend.persistence.repositories")
@EntityScan(basePackages = "com.devopsbuddy.backend.persistence.domain.backend")
@EnableTransactionManagement //transcation management
@PropertySource("file:///${user.home}/Documents/dev/application-common.properties")
//@PropertySource("file:///${user.home}/Documentos/dev/application-common.properties")
public class ApplicationConfig {

}

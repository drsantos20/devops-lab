/**
 * 
 */
package com.devopsbuddy.config;

import com.devopsbuddy.backend.service.UserSecurityService;
import com.devopsbuddy.web.controllers.ContactController;
import com.devopsbuddy.web.controllers.ForgotMyPasswordController;
import com.devopsbuddy.web.controllers.IndexController;
import com.devopsbuddy.web.controllers.SignupController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel on 21 de abr de 2017
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private Environment env;
	
	/** The encryption SALT random characters */ 
	private static final String SALT = "fdsafdsgttgdsfgfdsg";
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	/** Public URLs */ 
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/favicon/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**",
            "/signup/**",
            ForgotMyPasswordController.FORGOT_PASSWORD_URL_MAPPING,
            ForgotMyPasswordController.CHANGE_PASSWORD_PATH,
            SignupController.SIGNUP_URL_MAPPING,
            SignupController.SUBSCRIPTION_VIEW_NAME,
			IndexController.INDEX_HOME_PAGE,
			ContactController.CONTACT_US_SUCCESS_VIEW_NAME
    };
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 //getActive Profiles from enviroment and disable csrf for dev 
		 List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
	     if (activeProfiles.contains("dev")) {
	         http.csrf().disable();
	         http.headers().frameOptions().disable();
	     }
		
		
		http
			.authorizeRequests()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").defaultSuccessUrl("/payload")
			.failureUrl("/login?error").permitAll()
			.and().logout().permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userSecurityService) //inject here
			.passwordEncoder(passwordEncoder());
		
		/*	 in Memory authentication
			.inMemoryAuthentication()
			.withUser("user").password("password")
			.roles("USER");
		*/
	}

}

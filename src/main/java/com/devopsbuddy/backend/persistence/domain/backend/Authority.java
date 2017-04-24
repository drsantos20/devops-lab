package com.devopsbuddy.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * created by drsantos on 24-04-2017
 */

public class Authority implements GrantedAuthority { //encapsulare user role
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}

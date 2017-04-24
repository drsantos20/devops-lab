/**
 * 
 */
package com.devopsbuddy.backend.persistence.domain.backend;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Daniel on 23 de abr de 2017
 */
@Entity
@Table(name="user_role")
public class UserRole implements Serializable {
	
	/** The Serial Version UID for Serializable classes */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}



	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	

}

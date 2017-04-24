/**
 * 
 */
package com.devopsbuddy.backend.persistence.domain.backend;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.devopsbuddy.enums.RolesEnum;

/**
 * @author Daniel on 23 de abr de 2017
 */
@Entity
public class Role implements Serializable {
	
	/** The Serial Version UID for Serializable classes */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public Role(RolesEnum rolesEnum) {
		this.id = rolesEnum.getId();
		this.name = rolesEnum.getRoleName();
	}
	
	
	
	public Role() {
		super();
	}

	@Id
	private int id;
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<UserRole> userRoles = new HashSet<>();
	
	private String name;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userRoles
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles the userRoles to set
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}

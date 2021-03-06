package com.devopsbuddy.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;

import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import com.devopsbuddy.enums.PlansEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.enums.UserUtils;

/**
 * created by drsantos on 25-04-2017
 */

public abstract class AbstractIntegrationTest {
	
    @Autowired
    protected PlanRepository planRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected UserRepository userRepository;
    
	/**
	 * @return
	 */
    protected Role createRole(RolesEnum rolesEnum) {
		return new Role(rolesEnum);
	}

	/**
	 * @return
	 */
	protected Plan createPlan(PlansEnum plansEnum) {
		return new Plan(plansEnum);
	}
    
    
    protected User CreateUser(String username, String email) {
		Plan basicPlan = createPlan(PlansEnum.BASIC);
		planRepository.save(basicPlan);
		
		User basicUser = UserUtils.createBasicUser(username, email);
		basicUser.setPlan(basicPlan);
		
		Role basicRole = createRole(RolesEnum.BASIC);
		roleRepository.save(basicRole);
		
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole(basicUser, basicRole);
		userRoles.add(userRole);
		
		basicUser.getUserRoles().addAll(userRoles);
		basicUser = userRepository.save(basicUser);
		
		return basicUser;
	}
    
    protected User CreateUser(TestName testName) {
    	return CreateUser(testName.getMethodName(), testName.getMethodName() + "devopsbuddy.com");
    }
    
    

}

package com.devopsbuddy.enums;

import com.devopsbuddy.backend.persistence.domain.backend.User;

/**
 * created by drsantos on 24-04-2017
 */

public class UserUtils {
	
	private UserUtils() {
		throw new AssertionError("Non instantiable");
	}
	
    /**
     * Creates a user with basic attributes set.
     * @param username The username.
     * @param email The email.
     * @return A User entity
     */
    public static User createBasicUser() {

        User user = new User();
        user.setUsername("username");
        user.setPassword("secret");
        user.setEmail("drsantos20@gmail.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("123456789123");
        user.setCountry("GB");
        user.setEnable(true);
        user.setDescription("A basic user");
        user.setProfileImageURL("https://blabla.images.com/basicuser");

        return user;
    }

}

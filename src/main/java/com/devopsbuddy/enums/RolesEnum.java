package com.devopsbuddy.enums;

/**
 * created by drsantos on 24-04-2017
 */

public enum RolesEnum {
	
	BASIC(1, "ROLE_BASIC"),
    PRO(2, "ROLE_PRO"),
    ADMIN(3, "ROLE_ADMIN");


    private final int id;

    private final String roleName;

    RolesEnum(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

}

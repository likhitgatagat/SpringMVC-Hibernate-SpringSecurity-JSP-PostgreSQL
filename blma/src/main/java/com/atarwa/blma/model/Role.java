package com.atarwa.blma.model;

public enum Role {
	USER("USER"),
    ADMIN("ADMIN");
     
    String roleType;
     
    private Role(String profileType){
        this.roleType = profileType;
    }
     
    public String getRoleType(){
        return roleType;
    }
    
    public static boolean contains(String userRole) {
	    for (Role role : Role.values()) {
		    if (role.name().equals(userRole)) {
		        return true;
		    }
	    }
        return false;
    }
}

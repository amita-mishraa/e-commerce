package com.commerce.e_commerce.dto;

import com.commerce.e_commerce.role.UserRole;

import lombok.Data;

@Data
public class SignupDTO {

    private String name;
	
	private String email;
	
	private String password;
	
	private UserRole userRole;
	
}



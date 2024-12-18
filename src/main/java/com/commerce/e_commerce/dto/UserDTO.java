package com.commerce.e_commerce.dto;

import com.commerce.e_commerce.role.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

	private long id;
	
	private String name;
	
	private String email;
	
	@JsonIgnore
	private String password;
	
	@JsonIgnore
	private UserRole userRole;
	
	
}

package com.commerce.e_commerce.entity;

import com.commerce.e_commerce.dto.UserDTO;
import com.commerce.e_commerce.role.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private UserRole userRole;
	
	private byte[] img;
	
}


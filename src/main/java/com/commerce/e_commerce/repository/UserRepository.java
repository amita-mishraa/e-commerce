package com.commerce.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.commerce.e_commerce.entity.User;
import com.commerce.e_commerce.role.UserRole;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findFirstByEmail(@Param("email") String email);

	 @Query("SELECT COUNT(u) FROM User u WHERE u.userRole = :role")
	    long countByUserRole(@Param("role") UserRole role);

}

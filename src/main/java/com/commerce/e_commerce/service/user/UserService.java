package com.commerce.e_commerce.service.user;

import com.commerce.e_commerce.dto.SignupDTO;
import com.commerce.e_commerce.dto.UserDTO;

public interface UserService {

	UserDTO createUser(SignupDTO signupDto);

	boolean hasUserWithEmail(String email);

}

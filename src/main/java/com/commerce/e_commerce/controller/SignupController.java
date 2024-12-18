package com.commerce.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.commerce.e_commerce.dto.SignupDTO;
import com.commerce.e_commerce.dto.UserDTO;
import com.commerce.e_commerce.service.user.UserService;

@RestController
public class SignupController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/sign-up")
	public ResponseEntity<?> signup(@RequestBody SignupDTO signupDto){
		if (userService.hasUserWithEmail(signupDto.getEmail())) {
			return new ResponseEntity<>("User has already exist", HttpStatus.NOT_ACCEPTABLE);
		}
      UserDTO created = userService.createUser(signupDto);
       if(created == null)
       {
    	   return new ResponseEntity<>("Not Created, Try Again!!", HttpStatus.BAD_REQUEST);
       }
    	   return new ResponseEntity<>(created, HttpStatus.CREATED);
       
	}
}

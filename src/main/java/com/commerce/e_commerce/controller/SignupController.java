package com.commerce.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.e_commerce.dto.SignupDTO;
import com.commerce.e_commerce.entity.User;
import com.commerce.e_commerce.repository.UserRepository;
import com.commerce.e_commerce.role.UserRole;

@RestController
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignupDTO signupDto) {
   
        if (userRepository.findFirstByEmail(signupDto.getEmail()) != null) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }


        if (signupDto.getUserRole() == UserRole.ADMIN && userRepository.countByUserRole(UserRole.ADMIN) >= 2) {
            return new ResponseEntity<>("Cannot create more than 2 admins", HttpStatus.FORBIDDEN);
        }

        User user = new User();
        user.setName(signupDto.getName());
        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword());
        user.setUserRole(signupDto.getUserRole() != null ? signupDto.getUserRole() : UserRole.USER); // Default to USER role if none provided

        userRepository.save(user);

        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}

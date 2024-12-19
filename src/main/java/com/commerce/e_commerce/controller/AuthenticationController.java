package com.commerce.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.e_commerce.dto.AuthenticationRequest;
import com.commerce.e_commerce.dto.UserDTO;
import com.commerce.e_commerce.entity.User;
import com.commerce.e_commerce.repository.UserRepository;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        User user = userRepository.findFirstByEmail(request.getEmail());

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.UNAUTHORIZED);
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUserRole(user.getUserRole());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}

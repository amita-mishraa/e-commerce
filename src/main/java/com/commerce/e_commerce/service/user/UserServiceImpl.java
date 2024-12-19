package com.commerce.e_commerce.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commerce.e_commerce.dto.SignupDTO;
import com.commerce.e_commerce.dto.UserDTO;
import com.commerce.e_commerce.entity.User;
import com.commerce.e_commerce.repository.UserRepository;
import com.commerce.e_commerce.role.UserRole;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDto) {
        System.out.println("Password in SignupDTO: " + signupDto.getPassword());

        User user = new User();
        user.setName(signupDto.getName());
        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword()); 
        user.setUserRole(signupDto.getUserRole() != null ? signupDto.getUserRole() : UserRole.USER);

        System.out.println("User before saving: " + user);

        User createdUser = userRepository.save(user);

        UserDTO userDto = new UserDTO();
        userDto.setId(createdUser.getId());
        userDto.setName(createdUser.getName());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserRole(createdUser.getUserRole());

        return userDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }
}




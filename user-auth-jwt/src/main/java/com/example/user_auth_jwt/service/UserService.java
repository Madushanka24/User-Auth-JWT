
package com.example.user_auth_jwt.service;

import com.example.user_auth_jwt.model.User;
import com.example.user_auth_jwt.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registerUser(String username, String password) {

        // Encode password before saving
        User user = new User(username, passwordEncoder.encode(password), "ROLE_USER");
        return userRepository.save(user);
    }
}

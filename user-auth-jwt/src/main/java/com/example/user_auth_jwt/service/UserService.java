
package com.example.user_auth_jwt.service;

import com.example.user_auth_jwt.model.User;
import com.example.user_auth_jwt.repository.UserRepository;
import com.example.user_auth_jwt.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password), "ROLE_USER");
        return userRepository.save(user);
    }

    // Authenticate user
    public boolean authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
    }

    public String login(String username, String password) {
        boolean authenticated = authenticate(username, password);
        if (!authenticated) {
            throw new RuntimeException("Invalid username or password");
        }
        return JwtUtil.generateToken(username);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}

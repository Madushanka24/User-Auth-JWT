package com.example.user_auth_jwt.controller;

import com.example.user_auth_jwt.dto.LoginRequest;
import com.example.user_auth_jwt.dto.RegisterRequest;
import com.example.user_auth_jwt.model.User;
import com.example.user_auth_jwt.security.JwtUtil;
import com.example.user_auth_jwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Check if username exists
        if (userService.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        // Register the user
        userService.registerUser(request.getUsername(), request.getPassword());

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        boolean authenticated = userService.authenticate(request.getUsername(), request.getPassword());

        if (!authenticated) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(token);
    }

}

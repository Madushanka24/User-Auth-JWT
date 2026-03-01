package com.example.user_auth_jwt.controller;

import com.example.user_auth_jwt.dto.RegisterRequest;
import com.example.user_auth_jwt.model.User;
import com.example.user_auth_jwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        User user = userService.registerUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User registered successfully: " + user.getUsername());
    }
}

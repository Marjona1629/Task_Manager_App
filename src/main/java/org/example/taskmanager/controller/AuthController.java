package org.example.taskmanager.controller;

import org.example.taskmanager.dto.AuthRequest;
import org.example.taskmanager.dto.AuthResponse;
import org.example.taskmanager.model.User;
import org.example.taskmanager.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Register endpoint
    @PostMapping("/register")
    public User register(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam(defaultValue = "USER") String role) {
        return authService.register(username, password, role);
    }

    // Login endpoint
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
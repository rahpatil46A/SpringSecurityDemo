package com.example.UserSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserSecurity.dtos.RegisterRequestDto;
import com.example.UserSecurity.services.abstraction.JwtService;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {
	@Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto request) {
        jwtService.registerUser(request);
        return ResponseEntity.ok("User registered successfully!");
    }
}

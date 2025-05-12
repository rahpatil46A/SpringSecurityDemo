package com.example.UserSecurity.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UserSecurity.dtos.RegisterRequestDto;
import com.example.UserSecurity.models.User;
import com.example.UserSecurity.repository.UserRepository;
import com.example.UserSecurity.services.abstraction.JwtService;

@Service
public class JwtServiceImpl implements JwtService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void registerUser(RegisterRequestDto request) {
		if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered.");
        }

        User user = User.builder()
        				.firstName(request.getFirstName())
        				.lastName(request.getLastName())
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build();

        userRepository.save(user);
		
	}
}

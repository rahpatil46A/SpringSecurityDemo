package com.example.UserSecurity.services.abstraction;

import com.example.UserSecurity.dtos.RegisterRequestDto;

public interface JwtService {
	public void registerUser(RegisterRequestDto request);
}

package com.example.UserSecurity.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RegisterRequestDto {
	@NotBlank(message = "Enter First name")
	private String firstName;
	@NotBlank(message = "Enter last name")
	private String lastName;
	@Email(message = "Enter valid email")
	private String email;
	
    private String password;
}

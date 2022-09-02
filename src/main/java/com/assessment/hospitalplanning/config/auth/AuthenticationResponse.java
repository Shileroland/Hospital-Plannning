package com.assessment.hospitalplanning.config.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
	
	private final String token;
	private final String name;

	
	
	
	

}

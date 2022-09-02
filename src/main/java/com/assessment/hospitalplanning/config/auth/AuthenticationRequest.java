package com.assessment.hospitalplanning.config.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationRequest {
	
	String username;
	String password;
	
	
	

}

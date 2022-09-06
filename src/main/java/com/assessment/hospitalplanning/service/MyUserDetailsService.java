package com.assessment.hospitalplanning.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assessment.hospitalplanning.model.StaffProfile;
import com.assessment.hospitalplanning.repository.StaffRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	StaffRepository staffRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			StaffProfile staffProfile = staffRepository.findByName(username);
			if (staffProfile.getId() != null) {
				System.out.println("Received:::"+ username+ "FETCHED--->"+staffProfile.getName());
				return new User(staffProfile.getName(),staffProfile.getPassword(),new ArrayList<>());	
			}
		
		} catch (SQLException e) {
			System.out.println("An Error Occurred");
			e.printStackTrace();
		}
		return new User(null,null,new ArrayList<>());
	}

}

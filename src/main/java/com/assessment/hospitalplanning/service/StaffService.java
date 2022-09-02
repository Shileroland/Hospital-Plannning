package com.assessment.hospitalplanning.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assessment.hospitalplanning.dto.StaffDTO;


@Service
public interface StaffService {



	public ResponseEntity<?> staff(StaffDTO staffDTO);
	
	public ResponseEntity<?> staffUpdate(StaffDTO staffDto);
	

	
	

}

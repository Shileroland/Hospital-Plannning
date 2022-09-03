package com.assessment.hospitalplanning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.assessment.hospitalplanning.model.StaffProfile;
import com.assessment.hospitalplanning.service.PatientService;
import com.assessment.hospitalplanning.service.StaffService;

import junit.framework.TestCase;

public class HospitalPlanningTestCase extends TestCase {
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	PatientService patientService;


//	 @Test
//	    public void testInsert_Success() {
//	        // setup
//	        // Initialize test user data
//	        StaffProfile expected = new StaffProfile();
//	        // exercise
//	        staffService.staff(null);
//	        // assert
////	        StaffProfile actual = staffService
//	        Assertions.assertEquals(expected, actual);
//	    }
}

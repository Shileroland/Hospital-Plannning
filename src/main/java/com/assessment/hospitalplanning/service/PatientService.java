package com.assessment.hospitalplanning.service;

import java.io.Writer;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface PatientService {
	public ResponseEntity<?> retrievePatients(Integer age,Pageable Pageable);
	public ResponseEntity<?> deletePatientUsingDateRange(String fromDate,String toDate);
	void downloadPatientProfile(Writer writer);

}

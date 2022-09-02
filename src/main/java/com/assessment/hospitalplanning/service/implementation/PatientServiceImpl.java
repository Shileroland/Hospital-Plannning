package com.assessment.hospitalplanning.service.implementation;

import java.io.Writer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assessment.hospitalplanning.dto.PaginationModel;
import com.assessment.hospitalplanning.model.PatientProfile;
import com.assessment.hospitalplanning.repository.PatientRepository;
import com.assessment.hospitalplanning.response.MessageResponse;
import com.assessment.hospitalplanning.response.ResponseConstants;
import com.assessment.hospitalplanning.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	public ResponseEntity<?> retrievePatients(Integer age,Pageable Pageable) {
		PaginationModel<PatientProfile> paginationModel = new PaginationModel();
		try {
			System.out.println("it got here");
			Page<PatientProfile> patientProfile = patientRepository.retrieveAllPatients(age,Pageable);
			paginationModel.setContent(patientProfile.getContent());
			paginationModel.setTotalElements(patientProfile.getTotalElements());
			paginationModel.setTotalPages(patientProfile.getTotalPages());
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse<Object>(
					ResponseConstants.SUCCEESS_CODE, ResponseConstants.SUCCEESS_MESSAGE, paginationModel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new MessageResponse<Object>(ResponseConstants.FAILED_CODE, ResponseConstants.FAILED_MESSAGE, null));
		}
	}
	
	@Override
	public ResponseEntity<?> deletePatientUsingDateRange(String fromDate,String toDate) {
		try {
			patientRepository.deletePatient(fromDate, toDate);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new MessageResponse<Object>(ResponseConstants.FAILED_CODE, ResponseConstants.FAILED_MESSAGE, null));
		}

		return ResponseEntity.status(HttpStatus.OK).body(
				new MessageResponse<Object>(ResponseConstants.SUCCEESS_CODE, ResponseConstants.SUCCEESS_MESSAGE, null));
	}
	
	

	@Override
	public void downloadPatientProfile(Writer writer) {
		try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			PatientProfile patientProfile = patientRepository.findPatientById(null);
			csvPrinter.printRecord(patientProfile.getId(),patientProfile.getName(),patientProfile.getAge(),patientProfile.getLastVisitDate());
		} catch (Exception e) {
			System.out.println("Error While writing CSV "+e.getLocalizedMessage());
		}
		
	}
	
	
	

}

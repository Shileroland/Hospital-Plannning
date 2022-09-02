package com.assessment.hospitalplanning.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.assessment.hospitalplanning.model.PatientProfile;


@Repository
public interface PatientRepository extends PagingAndSortingRepository<PatientProfile,Integer> {
	PatientProfile findPatientById(Integer patientId);
	
	@Query(value = "SELECT * FROM PATIENT WHERE AGE > COALESCE(?1, AGE)",
			countQuery = "SELECT count(*) FROM PATIENT WHERE AGE > COALESCE(?1, AGE)",
			nativeQuery =true)
	Page<PatientProfile> retrieveAllPatients(Integer age,Pageable pageable);
	
	
	@Query(value = "DELETE FROM PATIENT WHERE LAST_VISIT_DATE BETWEEN ?1 AND ?2",nativeQuery =true)
	public abstract void deletePatient(String fromDate, String toDate);
	
}

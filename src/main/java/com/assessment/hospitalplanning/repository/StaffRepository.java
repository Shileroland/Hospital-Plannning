package com.assessment.hospitalplanning.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.hospitalplanning.model.StaffProfile;



@Repository
public interface StaffRepository extends JpaRepository<StaffProfile,Integer> {
	StaffProfile findStaffByUuid(String uuid);
	  
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO STAFF_PROFILE(NAME,PASSWORD,UUID,REGISTRATION_DATE)"
    		+ "VALUES (?,?,?,?);", nativeQuery = true)
    public abstract StaffProfile addStaff(String name,String password,String uuid,String registrationDate) throws SQLException;
    
    public abstract StaffProfile findByName(String name) throws SQLException;
    public abstract StaffProfile findByUuid(String uuid) throws SQLException;

}

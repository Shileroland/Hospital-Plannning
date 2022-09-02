package com.assessment.hospitalplanning.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "PATIENT")
public class PatientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID",nullable = false)
    private Integer id;
    @Column(name= "Name",nullable = false)
    private String name;
    @Column(name= "AGE",nullable = false)
    private Integer age;
    @Column(name= "LAST_VISIT_DATE",nullable = false)
    private String lastVisitDate;
//    @ManyToOne
//    private StaffProfile staff;

}

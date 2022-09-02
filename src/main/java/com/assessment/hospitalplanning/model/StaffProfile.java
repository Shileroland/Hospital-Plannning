package com.assessment.hospitalplanning.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Date;


@Data
@Entity
@Table(name="STAFF")
public class StaffProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Integer id;
    @Column(name= "NAME")
    private String name;
    @Column(name= "UUID")
    private String uuid;
    @Column(name= "REGISTRATION_DATE")
    private String registrationDate;
}

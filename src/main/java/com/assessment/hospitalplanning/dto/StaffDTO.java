package com.assessment.hospitalplanning.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class StaffDTO {
	@NotBlank
    private String name;
    private String uuid;
    private String password;
    private String registrationDate;
}

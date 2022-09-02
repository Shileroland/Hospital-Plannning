package com.assessment.hospitalplanning.exceptions;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
 
@XmlRootElement(name = "error")
@Data
public class ErrorResponse 
{
	
	
    //General error message about nature of error
	private String status;
    private String message;
    
	//Specific errors in API request processing
    private List<String> data;
    
    
    public ErrorResponse(String status, String message, List<String> data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
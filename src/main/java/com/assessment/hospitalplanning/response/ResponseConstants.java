package com.assessment.hospitalplanning.response;


public class ResponseConstants {
	/*
	 * Response Codes and Messages
	 */

	// success
	public static final String SUCCEESS_CODE = "00";
	public static final String SUCCEESS_MESSAGE = "Successful";
	
	// success
	public static final String FAILED_CODE = "01";
	public static final String FAILED_MESSAGE = "Unexpected Error Occurred";
	


	// web service unavailable
	public static final String WEBSERVICE_UNAVAILABLE_CODE = "02";
	public static final String WEBSERVICE_UNAVAILABLE_MESSAGE = "Web Service unreachable";

	// already exist
	public static final String ALREADY_EXIST_CODE = "05";
	public static final String ALREADY_EXIST_MESSAGE = "Record already exist ";

	// not found
	public static final String NOT_FOUND_CODE = "06";
	public static final String NOT_FOUND_MESSAGE = "Not Found";
	
	
	// exceeded limit
	public static final String NO_INPUT_CODE = "19";
	public static final String NO_INPUT_MESSAGE = "No Input";
	
	//server error
	public static final String SERVER_ERROR_CODE = "99";
	public static final String SERVER_ERROR_MESSAGE = "Server Error";
	
	//validation failed
	public static final String VALIDATION_FAILED_CODE = "98";
	public static final String VALIDATION_FAILED_MESSAGE = "Validation Failed";

}

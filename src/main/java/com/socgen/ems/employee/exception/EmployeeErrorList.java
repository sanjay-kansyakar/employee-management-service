package com.socgen.ems.employee.exception;

/**
 * 
 * @author Sanjay Kansyakar
 */
public enum EmployeeErrorList {
	
	INTERNAL_ERROR("EMS001","Internal Server Error."),
	PAYLOAD_ERROR("EMS002","Invalid or Empty payload."),
	INVALID_FIRSTNAME("EMS003","Invalid firstname passed payload."),
	INVALID_LASTNAME("EMS004","Invalid lastname passed payload."),
	INVALID_DEPARTMENT("EMS005","Invalid department passed payload."),
	INVALID_DOB("EMS006","Invalid DOB passed payload."),
	INVALID_EMPLOYEE_ID("EMS007","Invalid employee id passed in request.");

	private String code;
	private String message;
	
	private EmployeeErrorList(String code , String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}

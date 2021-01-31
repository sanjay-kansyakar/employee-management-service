package com.socgen.ems.employee.exception;

/**
 * 
 * @author Sanjay Kansyakar
 */
public class EmployeeServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -14663560889478325L;
	
	private ErrorDetails errorDetails;
	private int statusCode;
	
	public EmployeeServiceException(ErrorDetails errorDetails, int statusCode) {
		this.errorDetails = errorDetails;
		this.statusCode = statusCode;
	}
	
	public EmployeeServiceException(EmployeeErrorList employeeErrorList, int statusCode) {
		this.errorDetails = new ErrorDetails(employeeErrorList.getCode(), employeeErrorList.getMessage());
		this.statusCode = statusCode;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}
	
	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	

}

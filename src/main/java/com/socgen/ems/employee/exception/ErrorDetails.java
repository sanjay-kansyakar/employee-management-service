package com.socgen.ems.employee.exception;

import java.io.Serializable;

/**
 * 
 * @author Sanjay Kansyakar
 */
public class ErrorDetails implements Serializable {
	
	private static final long serialVersionUID = 178122554361918293L;

	private String errorCode;
	private String errorMessage;
	
	public ErrorDetails(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

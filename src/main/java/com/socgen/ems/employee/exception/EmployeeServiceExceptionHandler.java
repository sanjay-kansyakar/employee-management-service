package com.socgen.ems.employee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author Sanjay Kansyakar
 */
@ControllerAdvice
public class EmployeeServiceExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceExceptionHandler.class);
	
	@ExceptionHandler({ EmployeeServiceException.class })
	public ResponseEntity<Object> handleBadRequestExceptions(Exception exception) {
		logException(exception);
		EmployeeServiceException employeeServiceException = (EmployeeServiceException) exception;
		return decorateHttpServletResponse(employeeServiceException.getErrorDetails(), employeeServiceException.getStatusCode());
	}
	
	@ExceptionHandler({ HttpMessageNotReadableException.class })
	public ResponseEntity<Object> handleMessageNotReadableExceptions(Exception exception) {
		logException(exception);
		ErrorDetails errorDetails = new ErrorDetails(EmployeeErrorList.PAYLOAD_ERROR.getCode(), EmployeeErrorList.PAYLOAD_ERROR.getMessage());
		return decorateHttpServletResponse(errorDetails, HttpStatus.BAD_REQUEST.value());
	}
	
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleSystemErrors(Exception exception) {
		logException(exception);
		ErrorDetails errorDetails = new ErrorDetails(EmployeeErrorList.INTERNAL_ERROR.getCode(), EmployeeErrorList.INTERNAL_ERROR.getMessage());
		return decorateHttpServletResponse(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	private void logException(final Exception ex) {
		LOGGER.error(" !!! Exception Occured !!! ", ex);
	}

	private ResponseEntity<Object> decorateHttpServletResponse(ErrorDetails errorDetails, int statusCode) {
		if (null == errorDetails) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Object>(errorDetails, HttpStatus.valueOf(statusCode));
		}
	}

}

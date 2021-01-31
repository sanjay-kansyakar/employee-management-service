package com.socgen.ems.employee.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 
 * @author Sanjay Kansyakar
 * 
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceExceptionHandlerTest {
	
	@InjectMocks
	private EmployeeServiceExceptionHandler employeeServiceExceptionHandler;
	
	@Test
	public void testHandleBadRequestExceptions (){
		EmployeeServiceException employeeServiceException = new EmployeeServiceException(EmployeeErrorList.INVALID_FIRSTNAME, HttpStatus.BAD_REQUEST.value());
		ResponseEntity<Object> response = employeeServiceExceptionHandler.handleBadRequestExceptions(employeeServiceException);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		ErrorDetails errorDetails = (ErrorDetails) response.getBody();
		Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), errorDetails.getErrorCode());
		Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), errorDetails.getErrorMessage());
	}
	
	@Test
	public void testHandleMessageNotReadableExceptions (){
		ResponseEntity<Object> response = employeeServiceExceptionHandler.handleMessageNotReadableExceptions(new Exception());
		Assertions.assertNotNull(response);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		ErrorDetails errorDetails = (ErrorDetails) response.getBody();
		Assertions.assertEquals(EmployeeErrorList.PAYLOAD_ERROR.getCode(), errorDetails.getErrorCode());
		Assertions.assertEquals(EmployeeErrorList.PAYLOAD_ERROR.getMessage(), errorDetails.getErrorMessage());
	}
	
	@Test
	public void testHandleSystemErrors (){
		ResponseEntity<Object> response = employeeServiceExceptionHandler.handleSystemErrors(new Exception());
		Assertions.assertNotNull(response);
		Assertions.assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
		ErrorDetails errorDetails = (ErrorDetails) response.getBody();
		Assertions.assertEquals(EmployeeErrorList.INTERNAL_ERROR.getCode(), errorDetails.getErrorCode());
		Assertions.assertEquals(EmployeeErrorList.INTERNAL_ERROR.getMessage(), errorDetails.getErrorMessage());
	}

}

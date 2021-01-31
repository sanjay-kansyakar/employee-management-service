package com.socgen.ems.employee.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.socgen.ems.employee.exception.EmployeeErrorList;
import com.socgen.ems.employee.exception.EmployeeServiceException;
import com.socgen.ems.employee.model.Employee;
import com.socgen.ems.employee.utils.EmployeeTestUtils;

/**
 * 
 * @author Sanjay Kansyakar
 * 
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeValidatorTest {
	
	@InjectMocks
	private EmployeeValidator employeeValidator;
	
	@Test
	public void testValidateEmployee_NullEmployee() {
		try {
			EmployeeValidator.validateEmployee(null);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.PAYLOAD_ERROR.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.PAYLOAD_ERROR.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_NullFirstName() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setFirstName(null);
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_EmptyFirstName() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setFirstName("");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_InvalidFirstName() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setFirstName("123");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_NullLastName() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setLastName(null);
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_EmptyLastName() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setLastName("");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_InvalidLastName() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setLastName("123");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_NullDepartment() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setDepartment(null);
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_EmptyDepartment() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setDepartment("");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_InvalidDepartment() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setDepartment("123");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_NullDOB() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setDob(null);
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_EmptyDOB() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setDob("");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testValidateEmployee_InvalidDOB() {
		try {
			Employee employee = EmployeeTestUtils.mockedEmployee();
			employee.setDob("123");
			EmployeeValidator.validateEmployee(employee);
		} catch (EmployeeServiceException exception) {
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}

}

package com.socgen.ems.employee.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.socgen.ems.employee.exception.EmployeeErrorList;
import com.socgen.ems.employee.exception.EmployeeServiceException;
import com.socgen.ems.employee.model.Employee;
import com.socgen.ems.employee.service.EmployeeServiceImpl;
import com.socgen.ems.employee.utils.EmployeeTestUtils;

/**
 * 
 * @author Sanjay Kansyakar
 * 
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerImplTest {
	
	@InjectMocks
	private EmployeeControllerImpl employeeControllerImpl;
	
	@Spy
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Test
	public void testCreateEmployee_HappyPath() {
		Employee expectedEmployee = EmployeeTestUtils.mockedEmployee();
		Mockito.doReturn(expectedEmployee).when(employeeServiceImpl).createEmployee(expectedEmployee);
		ResponseEntity<Employee> actualResponse = employeeControllerImpl.createEmployee(expectedEmployee);
		Assertions.assertNotNull(actualResponse);
		Assertions.assertTrue(HttpStatus.CREATED.equals(actualResponse.getStatusCode()));
		Employee actualEmployee = actualResponse.getBody();
		Assertions.assertNotNull(actualEmployee);
		Assertions.assertEquals(expectedEmployee.getFirstName(), actualEmployee.getFirstName());
		Assertions.assertEquals(expectedEmployee.getLastName(), actualEmployee.getLastName());
		Assertions.assertEquals(expectedEmployee.getDepartment(), actualEmployee.getDepartment());
		Assertions.assertEquals(expectedEmployee.getDob(), actualEmployee.getDob());
	}
	
	@Test
	public void testCreateEmployee_NullFirstName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setFirstName(null);
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_EmptyFirstName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setFirstName("");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_InvalidFirstName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setFirstName("123");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_FIRSTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_NullLastName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setLastName(null);
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_EmptyLastName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setLastName("");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_InvalidLastName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setLastName("123");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_LASTNAME.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_NullDepartment() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setDepartment(null);
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_EmptyDepartment() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setDepartment("");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_InvalidDepartment() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setDepartment("123");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DEPARTMENT.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_NullDOB() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setDob(null);
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_EmptyDOB() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setDob("");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testCreateEmployee_InvalidDOB() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setDob("123");
		try{
			employeeControllerImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testGetAllEmployees_HappyPath() {
		Employee employee1 = EmployeeTestUtils.mockedEmployee("Alex");
		Employee employee2 = EmployeeTestUtils.mockedEmployee("Boby");
		Mockito.doReturn(Arrays.asList(employee1, employee2)).when(employeeServiceImpl).getAllEmployees();
		ResponseEntity<List<Employee>> response = employeeControllerImpl.getAllEmployees();
		Assertions.assertNotNull(response);
		Assertions.assertTrue(HttpStatus.OK.equals(response.getStatusCode()));
		List<Employee> employeeList = response.getBody();
		Assertions.assertNotNull(employeeList);
		Assertions.assertTrue(EmployeeTestUtils.isSorted(employeeList));
	}
	
	@Test
	public void testGetEmployeeById_HappyPath() {
		Employee expectedEmployee = EmployeeTestUtils.mockedEmployee();
		Mockito.doReturn(expectedEmployee).when(employeeServiceImpl).getEmployeeById("employeeId");
		ResponseEntity<Employee> actualResponse = employeeControllerImpl.getEmployeeById("employeeId");
		Assertions.assertNotNull(actualResponse);
		Assertions.assertTrue(HttpStatus.OK.equals(actualResponse.getStatusCode()));
		Employee actualEmployee = actualResponse.getBody();
		Assertions.assertNotNull(actualEmployee);
		Assertions.assertEquals(expectedEmployee.getFirstName(), actualEmployee.getFirstName());
		Assertions.assertEquals(expectedEmployee.getLastName(), actualEmployee.getLastName());
		Assertions.assertEquals(expectedEmployee.getDepartment(), actualEmployee.getDepartment());
		Assertions.assertEquals(expectedEmployee.getDob(), actualEmployee.getDob());
	}
	
	@Test
	public void testGetEmployeeById_NullEmployeeId() {
		try {
			employeeControllerImpl.getEmployeeById(null);
		} catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testGetEmployeeById_EmptyEmployeeId() {
		try {
			employeeControllerImpl.getEmployeeById("");
		} catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testGetEmployeeById_RecordDoesNotExist() {
		Mockito.doThrow(new EmployeeServiceException(EmployeeErrorList.INVALID_EMPLOYEE_ID, HttpStatus.NOT_FOUND.value())).when(employeeServiceImpl).getEmployeeById("employeeId");
		try {
			employeeControllerImpl.getEmployeeById("employeeId");
		} catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode());
        }
	}

}

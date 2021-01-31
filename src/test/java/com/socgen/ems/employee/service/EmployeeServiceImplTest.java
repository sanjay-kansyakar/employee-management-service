package com.socgen.ems.employee.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.socgen.ems.employee.dao.EmployeeRepository;
import com.socgen.ems.employee.entity.EmployeeEntity;
import com.socgen.ems.employee.exception.EmployeeErrorList;
import com.socgen.ems.employee.exception.EmployeeServiceException;
import com.socgen.ems.employee.model.Employee;
import com.socgen.ems.employee.utils.EmployeeTestUtils;
import com.socgen.ems.employee.utils.EmployeeUtils;

/**
 * 
 * @author Sanjay Kansyakar
 * 
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Mock
	private EmployeeUtils employeeUtils;
	
	@Test
	public void testCreateEmployee_HappyPath() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		EmployeeEntity employeeEntity = EmployeeTestUtils.mockedEmployeeEntity();
		when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
		when(employeeUtils.toEmployeeEntity(mockedEmployee)).thenReturn(employeeEntity);
		when(employeeUtils.toEmployee(employeeEntity)).thenReturn(mockedEmployee);
		Employee result = employeeServiceImpl.createEmployee(mockedEmployee);
		Assertions.assertNotNull(result);
		Assertions.assertEquals(mockedEmployee.getFirstName(), result.getFirstName());
		Assertions.assertEquals(mockedEmployee.getLastName(), result.getLastName());
		Assertions.assertEquals(mockedEmployee.getDepartment(), result.getDepartment());
		Assertions.assertEquals(mockedEmployee.getDob(), result.getDob());
	}
	
	@Test
	public void testCreateEmployee_NullFirstName() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		mockedEmployee.setFirstName(null);
		try{
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
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
			employeeServiceImpl.createEmployee(mockedEmployee);
        }catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_DOB.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testGetAllEmployees_HappyPath() {
		EmployeeEntity employeeEntity1 = EmployeeTestUtils.mockedEmployeeEntity("Boby");
		EmployeeEntity employeeEntity2 = EmployeeTestUtils.mockedEmployeeEntity("Alex");
		when(employeeRepository.findAll()).thenReturn(Arrays.asList(employeeEntity1, employeeEntity2));
		when(employeeUtils.toEmployee(employeeEntity1)).thenReturn(EmployeeTestUtils.mockedEmployee("Boby"));
		when(employeeUtils.toEmployee(employeeEntity2)).thenReturn(EmployeeTestUtils.mockedEmployee("Alex"));
		List<Employee> result = employeeServiceImpl.getAllEmployees();
		Assertions.assertNotNull(result);
		Assertions.assertTrue(EmployeeTestUtils.isSorted(result));
	}
	
	@Test
	public void testGetEmployeeById_HappyPath() {
		Employee mockedEmployee = EmployeeTestUtils.mockedEmployee();
		EmployeeEntity employeeEntity = EmployeeTestUtils.mockedEmployeeEntity();
		when(employeeRepository.findById("employeeId")).thenReturn(Optional.of(employeeEntity));
		when(employeeUtils.toEmployee(employeeEntity)).thenReturn(mockedEmployee);
		Employee result = employeeServiceImpl.getEmployeeById("employeeId");
		Assertions.assertNotNull(result);
		Assertions.assertEquals(mockedEmployee.getFirstName(), result.getFirstName());
		Assertions.assertEquals(mockedEmployee.getLastName(), result.getLastName());
		Assertions.assertEquals(mockedEmployee.getDepartment(), result.getDepartment());
		Assertions.assertEquals(mockedEmployee.getDob(), result.getDob());
	}
	
	@Test
	public void testGetEmployeeById_NullEmployeeId() {
		try {
			employeeServiceImpl.getEmployeeById(null);
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
			employeeServiceImpl.getEmployeeById("");
		} catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatusCode());
        }
	}
	
	@Test
	public void testGetEmployeeById_RecordDoesNotExist() {
		when(employeeRepository.findById("employeeId")).thenReturn(Optional.empty());
		try {
			employeeServiceImpl.getEmployeeById("employeeId");
		} catch(EmployeeServiceException exception){
        	Assertions.assertEquals(EmployeeServiceException.class, exception.getClass());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getCode(), exception.getErrorDetails().getErrorCode());
        	Assertions.assertEquals(EmployeeErrorList.INVALID_EMPLOYEE_ID.getMessage(), exception.getErrorDetails().getErrorMessage());
        	Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode());
        }
	}

}

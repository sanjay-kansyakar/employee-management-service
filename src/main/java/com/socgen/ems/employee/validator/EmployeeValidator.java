package com.socgen.ems.employee.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.socgen.ems.employee.exception.EmployeeErrorList;
import com.socgen.ems.employee.exception.EmployeeServiceException;
import com.socgen.ems.employee.model.Employee;

/**
 * 
 * @author Sanjay Kansyakar
 */
@Component
public class EmployeeValidator {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

	public static void validateEmployee(Employee employee) {
		if (employee == null) {
			throw new EmployeeServiceException(EmployeeErrorList.PAYLOAD_ERROR, HttpStatus.BAD_REQUEST.value());
		}
		if (employee.getFirstName() == null || employee.getFirstName().length() == 0) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_FIRSTNAME, HttpStatus.BAD_REQUEST.value());
		}
		if (!employee.getFirstName().matches("[a-zA-Z]*")) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_FIRSTNAME, HttpStatus.BAD_REQUEST.value());
		}
		if (employee.getLastName() == null || employee.getLastName().length() == 0) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_LASTNAME, HttpStatus.BAD_REQUEST.value());
		}
		if (!employee.getLastName().matches("[a-zA-Z]*")) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_LASTNAME, HttpStatus.BAD_REQUEST.value());
		}
		if (employee.getDepartment() == null || employee.getDepartment().length() == 0) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_DEPARTMENT, HttpStatus.BAD_REQUEST.value());
		}
		if (!employee.getDepartment().matches("[a-zA-Z_]*")) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_DEPARTMENT, HttpStatus.BAD_REQUEST.value());
		}
		if (employee.getDob() == null || employee.getDob().length() == 0) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_DOB, HttpStatus.BAD_REQUEST.value());
		}
		try {
			dateFormat.setLenient(false);
			dateFormat.parse(employee.getDob());
		} catch (ParseException e) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_DOB, HttpStatus.BAD_REQUEST.value());
		}

	}

}

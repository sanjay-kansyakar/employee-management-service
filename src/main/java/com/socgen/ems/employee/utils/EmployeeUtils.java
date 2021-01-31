package com.socgen.ems.employee.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.socgen.ems.employee.entity.EmployeeEntity;
import com.socgen.ems.employee.model.Employee;

/**
 * 
 * @author Sanjay Kansyakar
 */
@Component
public class EmployeeUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeUtils.class);
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

	public EmployeeEntity toEmployeeEntity(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId(employee.getEmployeeId());
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setDepartment(employee.getDepartment());
		try {
			employeeEntity.setDob(dateFormat.parse(employee.getDob()));
		} catch (ParseException ex) {
			LOGGER.error("Error while parsing given date ", ex);
		}
		return employeeEntity;
	}

	public Employee toEmployee(EmployeeEntity employeeEntity) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeEntity.getEmployeeId());
		employee.setFirstName(employeeEntity.getFirstName());
		employee.setLastName(employeeEntity.getLastName());
		employee.setDob(dateFormat.format(employeeEntity.getDob()));
		employee.setDepartment(employeeEntity.getDepartment());
		return employee;
	}

}

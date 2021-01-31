package com.socgen.ems.employee.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.socgen.ems.employee.model.Employee;

public interface EmployeeController {
	
	ResponseEntity<Employee> createEmployee(Employee employee);
	
	ResponseEntity<List<Employee>> getAllEmployees();
	
	ResponseEntity<Employee> getEmployeeById(String id);

}

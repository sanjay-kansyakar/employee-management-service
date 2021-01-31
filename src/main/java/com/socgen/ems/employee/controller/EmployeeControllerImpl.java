package com.socgen.ems.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.ems.employee.model.Employee;
import com.socgen.ems.employee.service.EmployeeService;


/**
 * 
 * @author Sanjay Kansyakar
 */
@RestController
public class EmployeeControllerImpl implements EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeControllerImpl.class);
	
	@Autowired
	private EmployeeService employeeService;


	@RequestMapping(method = RequestMethod.POST, path = "/v1/employees",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employeeDetails) {
		Employee employee = employeeService.createEmployee(employeeDetails);
		LOGGER.info("Successfully created Employee with id: {}", employee.getEmployeeId());
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/v1/employees",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		LOGGER.info("Successfully retrieved all employees");
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/v1/employees/{id}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Employee>  getEmployeeById(@PathVariable String id) {
		Employee employee = employeeService.getEmployeeById(id);
		LOGGER.info("Successfully retrieved details for employee id: {}",id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

}

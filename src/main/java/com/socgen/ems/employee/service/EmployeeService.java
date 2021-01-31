package com.socgen.ems.employee.service;

import java.util.List;

import com.socgen.ems.employee.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String id);

}

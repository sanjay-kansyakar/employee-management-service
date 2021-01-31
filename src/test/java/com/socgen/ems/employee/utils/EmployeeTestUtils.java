package com.socgen.ems.employee.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.socgen.ems.employee.entity.EmployeeEntity;
import com.socgen.ems.employee.model.Employee;

public class EmployeeTestUtils {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

	public static Employee mockedEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("firstName");
		employee.setLastName("lastName");
		employee.setDepartment("department");
		employee.setDob("1995-01-01");
		return employee;
	}

	public static EmployeeEntity mockedEmployeeEntity() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId("employeeId");
		employeeEntity.setFirstName("firstName");
		employeeEntity.setLastName("lastName");
		employeeEntity.setDepartment("department");
		try {
			employeeEntity.setDob(dateFormat.parse("1995-01-01"));
		} catch (ParseException e) {
		}
		return employeeEntity;
	}
	
	public static Employee mockedEmployee(String firstName) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName("lastName");
		employee.setDepartment("department");
		employee.setDob("1995-01-01");
		return employee;
	}
	
	public static EmployeeEntity mockedEmployeeEntity(String firstName) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId("employeeId");
		employeeEntity.setFirstName(firstName);
		employeeEntity.setLastName("lastName");
		employeeEntity.setDepartment("department");
		try {
			employeeEntity.setDob(dateFormat.parse("1995-01-01"));
		} catch (ParseException e) {
		}
		return employeeEntity;
	}
	
	public static boolean isSorted(List<Employee> employeeList) {
	    return isSorted(employeeList, employeeList.size());
	}

	private static boolean isSorted(List<Employee> employeeList, int index) {
	    if (index < 2) {
	        return true;
	    } else if (employeeList.get(index - 2).getFirstName().compareTo(employeeList.get(index - 1).getFirstName()) > 0) {
	        return false;
	    } else {
	        return isSorted(employeeList, index - 1);
	    }
	}

}

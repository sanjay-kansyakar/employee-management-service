package com.socgen.ems.employee.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.socgen.ems.employee.entity.EmployeeEntity;
import com.socgen.ems.employee.model.Employee;

/**
 * 
 * @author Sanjay Kansyakar
 * 
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeUtilsTest {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	
	@InjectMocks
	private EmployeeUtils employeeUtils;
	
	@Test
	public void testToEmployeeEntity_HappyPath() {
		Employee employee = EmployeeTestUtils.mockedEmployee();
		EmployeeEntity employeeEntity = employeeUtils.toEmployeeEntity(employee);
		Assertions.assertNotNull(employeeEntity);
		Assertions.assertEquals(employee.getFirstName(), employeeEntity.getFirstName());
		Assertions.assertEquals(employee.getLastName(), employeeEntity.getLastName());
		Assertions.assertEquals(employee.getDepartment(), employeeEntity.getDepartment());
		Assertions.assertEquals(employee.getDob(), dateFormat.format(employeeEntity.getDob()));
	}
	
	@Test
	public void testToEmployee_HappyPath() {
		EmployeeEntity employeeEntity = EmployeeTestUtils.mockedEmployeeEntity();
		Employee employee = employeeUtils.toEmployee(employeeEntity);
		Assertions.assertNotNull(employee);
		Assertions.assertEquals(employee.getFirstName(), employeeEntity.getFirstName());
		Assertions.assertEquals(employee.getLastName(), employeeEntity.getLastName());
		Assertions.assertEquals(employee.getDepartment(), employeeEntity.getDepartment());
		Assertions.assertEquals(employee.getDob(), dateFormat.format(employeeEntity.getDob()));
	}

}

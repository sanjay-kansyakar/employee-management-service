package com.socgen.ems.employee.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.socgen.ems.employee.dao.EmployeeRepository;
import com.socgen.ems.employee.entity.EmployeeEntity;
import com.socgen.ems.employee.exception.EmployeeErrorList;
import com.socgen.ems.employee.exception.EmployeeServiceException;
import com.socgen.ems.employee.model.Employee;
import com.socgen.ems.employee.utils.EmployeeUtils;
import com.socgen.ems.employee.validator.EmployeeValidator;


/**
 * 
 * @author Sanjay Kansyakar
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeUtils employeeUtils;
	
	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeValidator.validateEmployee(employee);
		LOGGER.info("validation successful");
		EmployeeEntity employeeDetails = employeeUtils.toEmployeeEntity(employee);
		Timestamp creationTime = new Timestamp(System.currentTimeMillis());
		employeeDetails.setCreatedDateTime(creationTime);
		employeeDetails.setUpdatedDateTime(creationTime);
		employeeDetails = employeeRepository.save(employeeDetails);
		return employeeUtils.toEmployee(employeeDetails);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (EmployeeEntity employeeDetail : employeeRepository.findAll()) {
			employees.add(employeeUtils.toEmployee(employeeDetail));
		}
		employees.sort(Comparator.comparing(Employee::getFirstName));
		return employees;
	}

	@Override
	public Employee getEmployeeById(String employeeId) {
		if (employeeId == null || employeeId.length() == 0) {
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_EMPLOYEE_ID, HttpStatus.BAD_REQUEST.value());
		}
		Optional<EmployeeEntity> employeeDetailsOptional = employeeRepository.findById(employeeId);
		EmployeeEntity employeeDetails = employeeDetailsOptional.orElse(null);
		if (employeeDetails == null) {
			LOGGER.error("EmployeeDetails not found for employeeId: {}", employeeId);
			throw new EmployeeServiceException(EmployeeErrorList.INVALID_EMPLOYEE_ID, HttpStatus.NOT_FOUND.value());
		}
		return employeeUtils.toEmployee(employeeDetails);
	}

}

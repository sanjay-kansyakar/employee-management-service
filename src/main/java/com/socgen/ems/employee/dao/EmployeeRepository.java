package com.socgen.ems.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.socgen.ems.employee.entity.EmployeeEntity;

/**
 * 
 * @author Sanjay Kansyakar
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, String> {

}

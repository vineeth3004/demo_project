package com.project.springboot.service;

import java.util.List;

import com.project.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, Long id);
	void deleteEmployeeById(Long id);
}

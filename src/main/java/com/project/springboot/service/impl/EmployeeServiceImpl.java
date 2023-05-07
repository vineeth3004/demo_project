package com.project.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.exception.ResourceNotFoundException;
import com.project.springboot.model.Employee;
import com.project.springboot.repository.EmployeeRepository;
import com.project.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee","Id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
   () -> new ResourceNotFoundException("Employee","Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.findById(id).orElseThrow(
				   () -> new ResourceNotFoundException("Employee","Id", id));
		employeeRepository.deleteById(id);
		
	}

}

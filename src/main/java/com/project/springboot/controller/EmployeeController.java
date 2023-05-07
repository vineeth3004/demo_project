package com.project.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.model.Employee;
import com.project.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
    @GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
    	return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK) ;
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployees(@PathVariable("id") Long employeeeId, @RequestBody Employee employee){
    	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeeId), HttpStatus.OK);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long idd){
    	employeeService.deleteEmployeeById(idd);
    	return new ResponseEntity<String>("Employee del Successfully", HttpStatus.OK);
    	
    }
}

package br.com.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.producer.domain.Employee;
import br.com.producer.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService; 
	
	@GetMapping("/employee")
	public ResponseEntity<Employee> getEmployee(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee());
	}
}

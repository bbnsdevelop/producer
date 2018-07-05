package br.com.producer.service.impl;

import org.springframework.stereotype.Service;

import br.com.producer.domain.Employee;
import br.com.producer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private static Employee employee;
	
	static{
		employee = new Employee(1L,"emp1","manager", 3000 );
	}
	
	@Override
	public Employee getEmployee() {
		
		return employee;
	}
	
	

}

package br.com.producer.service.impl;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.producer.domain.Employee;
import br.com.producer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private static Employee employee;
	
	static{
		employee = new Employee(1L,"emp1","manager", 3000 );
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee getEmployee() {
		if(employee.getName().equalsIgnoreCase("emp1"))
			throw new RuntimeException();
		
		return employee;
	}
	
	public Employee getDataFallBack() {

		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId(2L);
		emp.setSalary(3000);

		return emp;

	}
	
	

}

package br.com.producer.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.producer.domain.Employee;
import br.com.producer.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	private static Employee employee;
	
	static{
		employee = new Employee(1L,"emp1","manager", 3000 );
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee getEmployee() {
		log.info("call getEmployee()");
		if(isNull(employee.getName())){
			throw new RuntimeException();			
		}		
		return employee;
	}
	
	public Employee getDataFallBack() {
		log.info("call getDataFallBack()");

		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId(2L);
		emp.setSalary(3000);
		return emp;

	}
	
	

}

package com.shiwang.springboot.rest.crud.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiwang.springboot.rest.crud.dao.EmployeeDAO;
import com.shiwang.springboot.rest.crud.entity.Employee;

@RestController
@RequestMapping("/api")
public class MainController {

	
	private EmployeeDAO employeedao;
	
	@Autowired
	public MainController(EmployeeDAO empdao) {
		this.employeedao=empdao;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		List<Employee> employeelist= employeedao.getEmployees();
		
		return employeelist;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee= employeedao.getEmployeeById(employeeId);
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeedao.saveEmployee(employee);
		Employee emp=employeedao.getEmployeeById(employee.getId());
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeedao.saveEmployee(employee);
		Employee emp=employeedao.getEmployeeById(employee.getId());	
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		employeedao.deleteEmployeeById(employeeId);
		
		return "employee deleted with id = "+employeeId;
	}
	

}

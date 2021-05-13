package com.shiwang.springboot.rest.crud.dao;

import java.util.List;

import com.shiwang.springboot.rest.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(int employeeId);
	
	public void saveEmployee(Employee employee);
	
	public void deleteEmployeeById(int employeeId);
}

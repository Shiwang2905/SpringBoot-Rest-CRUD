package com.shiwang.springboot.rest.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shiwang.springboot.rest.crud.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

	private Session currentsession;
	private EntityManager entitymanager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager theentitymanager) {
		
		this.entitymanager=theentitymanager;
		this.currentsession=entitymanager.unwrap(Session.class);
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		Query<Employee> getquery=currentsession.createQuery("from Employee",Employee.class);
		
		List<Employee> employeelist=getquery.getResultList();
		
		return employeelist;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employeeId) {
		Employee employeeWithId=currentsession.get(Employee.class, employeeId);
		return employeeWithId;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		currentsession.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int employeeId) {
		Employee employee=currentsession.get(Employee.class, employeeId);
		currentsession.delete(employee);
		
	}
	

	

}

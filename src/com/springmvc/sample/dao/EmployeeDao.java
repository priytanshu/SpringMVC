package com.springmvc.sample.dao;

import java.util.List;

import com.springmvc.sample.model.Employee;

public interface EmployeeDao {
	
	public String addEmployee(Employee e);

	public List<Employee> listEmployee();

}

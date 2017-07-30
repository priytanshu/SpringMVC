package com.springmvc.sample.service;

import java.util.List;

import com.springmvc.sample.model.Employee;

public interface EmployeeService {

	public String addEmployee(Employee e);

	public List<Employee> listEmployee();

}

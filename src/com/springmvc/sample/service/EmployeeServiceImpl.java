package com.springmvc.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.sample.dao.EmployeeDao;
import com.springmvc.sample.model.Employee;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDaoObj;

	@Override
	public String addEmployee(Employee employee) {
		System.out.println("In Servce, calling DAO");
		employeeDaoObj.addEmployee(employee);
		return null;
	}

	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}

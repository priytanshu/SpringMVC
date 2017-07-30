package com.springmvc.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.sample.bean.EmployeeBean;
import com.springmvc.sample.model.Employee;
import com.springmvc.sample.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServiceObj;

	/*
	 * @RequestMapping(value = "/index") public ModelAndView welcome() { return
	 * new ModelAndView("index"); }
	 */

	@RequestMapping(value = "/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		return new ModelAndView("addEmployee");
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Employee employee = prepareModel(employeeBean);
		System.out.println("Employee name is :" + employee.getName());
		employeeServiceObj.addEmployee(employee);
		return new ModelAndView("employeesList");
	}

	@RequestMapping(value = "/viewEmployee")
	public ModelAndView viewEmployee(@ModelAttribute Employee employee) {
		return new ModelAndView("employeesList");
	}

	private Employee prepareModel(EmployeeBean employeeBean) {
		Employee employee = new Employee();
		employee.setName(employeeBean.getName());
		employee.setSalary(employeeBean.getSalary());
		employee.setDesignation(employeeBean.getDesignation());
		employeeBean.setId(null);
		return employee;
	}

}

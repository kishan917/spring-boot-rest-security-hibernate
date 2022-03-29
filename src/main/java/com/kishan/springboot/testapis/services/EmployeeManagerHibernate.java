package com.kishan.springboot.testapis.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kishan.springboot.testapis.dao.EmployeeDao;
import com.kishan.springboot.testapis.dao.EmployeeDaoHibernate;
import com.kishan.springboot.testapis.entities.Employee;

@Component()
public class EmployeeManagerHibernate {
	
	@Autowired
	EmployeeDaoHibernate employeeDaoHibernate;

	public List<Employee> getAllEmployees() {
		System.out.println("Fetching all employees..");
		return employeeDaoHibernate.getAllEmployees();
	}
	
	public String addRandomEmployee() {
		Employee employee =  new Employee();
		int randomInt = new Random().nextInt(999);
		employee.setEmployeeName("Employee_" + randomInt);
		employee.setEmployeeDepartment("Department_" + randomInt);
		employee.setEmployeeSalary(randomInt);
		return employeeDaoHibernate.addRandomEmployee(employee);
	}
	
}

package com.kishan.springboot.testapis.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.kishan.springboot.testapis.dao.EmployeeDao;
import com.kishan.springboot.testapis.entities.Employee;

@Component()
public class EmployeeManager {
	
	@Autowired
	EmployeeDao employeeDao;

	public EmployeeManager() {
		initializeEmployeeList(employeeList);
	}
	
	public static ArrayList<Employee> employeeList = new ArrayList<>();
	
	private void initializeEmployeeList(ArrayList<Employee> employeeList) {
		employeeList.add(new Employee(1, "Employee1", "Dept1", 150000));
		employeeList.add(new Employee(2, "Employee2", "Dept2", 250000));
		employeeList.add(new Employee(3, "Employee3", "Dept3", 350000));
		employeeList.add(new Employee(4, "Employee4", "Dept4", 450000));
	}
	
	public Employee getEmployeeById(int empployeeId) {
		System.out.println("Fetching employee with id : " + empployeeId);
		return employeeList.stream().filter(emp -> emp.getEmployeeId()==empployeeId).findAny().orElse(null);
	}
	
	public List<Employee> getEmployeeByDeptName(String employeeDepartment) {
		System.out.println("Fetching employee with department : " + employeeDepartment);
		return employeeDao.findByDepartmentName(employeeDepartment);
	}
	
	public List<Employee> getEmployeeByName(String empployeeName) {
		System.out.println("Fetching employee with name : " + empployeeName);
		return employeeDao.findByEmployeeName2(empployeeName);
	}
	
	public List<Employee> getAllEmployees() {
		System.out.println("Fetching all employees..");
		return employeeDao.findAll();
	}
	
	public Employee getEmployee(int employeeId) {
		System.out.println("Fetching employee with id : " + employeeId);
		return employeeDao.findById(employeeId).orElse(null);
	}

	public String addEmployee(Employee employee) {
		employeeDao.save(employee);
		return "Saved Employee with employeeId: " + employee.getEmployeeId();
	}
	
	public String updateEmployee(Employee employee, int employeeId) {
		employee.setEmployeeId(employeeId);
		employeeDao.save(employee);
		return "Updated Employee with employeeId: " + employee.getEmployeeId();
	}
	
	public String deleteEmployee(int employeeId) {
		System.out.println("Deleting employee with id : " + employeeId);
		employeeDao.deleteById(employeeId);
		return "Employee with employeeId: " + employeeId + " deleted.";
	}
	
}

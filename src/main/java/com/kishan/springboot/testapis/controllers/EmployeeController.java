package com.kishan.springboot.testapis.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kishan.springboot.testapis.dao.EmployeeDao;
import com.kishan.springboot.testapis.entities.Employee;
import com.kishan.springboot.testapis.services.EmployeeManager;

@RestController
@RequestMapping("/admin")
public class EmployeeController {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	EmployeeManager employeeManager;
	
	@GetMapping("/help")
	public String manageEmployee() {
		return "<p>\r\n"
				+ "	Welcome to Employee Management Service.</br>\r\n"
				+ "	Please fire APIs listed below</br>\r\n"
				+ "	</br>\r\n"
				+ "	<a href=\"/admin/employee\" > /admin/employee </a></br>\r\n"
				+ "		to fetch all employees</br>\r\n"
				+ "	</br>\r\n"
				+ "	<a href=\"/admin/employee/1\" > /admin/employee/{employeeId} </a></br>\r\n"
				+ "		to fetch specific employee using its ID e.g 1 2 3 </br>\r\n"
				+ "	</br>\r\n"
				+ "	<a href=\"/admin/employee/getEmployeeByName?employeeName=Employee_1\" > /admin/employee/getEmployeeByName?employeeName={employeeName} </a></br>\r\n"
				+ "		Yes...you guessed it right :)   Sample Employee names.. Employee_1, Employee_2, Employee_3</br>\r\n"
				+ "		</br>\r\n"
				+ "	<a href=\"/admin/employee/getEmployeeByDeptName?employeeDepartment=Department_1\" > /admin/employee/getEmployeeByDeptName?employeeDepartment={employeeDepartment} </a></br>\r\n"
				+ "		go for it....    Sample employeeDepartment .. Department_1, Department_2, Department_3</br></br>\r\n"
				+ "	</br>\r\n"
				+ "	<a href=\"/admin/addRandomEmployee\" > /admin/addRandomEmployee </a></br>\r\n"
				+ "		to add some employee</br>\r\n"
				+ "	</br>\r\n"
				+ "	<a href=\"/h2\" > Look into Database </a></br></br>\r\n"
				+ "	</br>\r\n"
				+ "	</br>\r\n"
				+ "	Here are some sample user accounts added in DB:</br>\r\n"
				+ "		username: admin, password: admin, role:AdminRole</br>\r\n"
				+ "		username: user, password: user, role:UserRole</br>\r\n"
				+ "		username: user1, password: user1, role:UserRole</br>\r\n"
				+ "		username: user2, password: user2, role:UserRole</br>\r\n"
				+ "	</br>\r\n"
				+ "	</br>\r\n"
				+ "	UI is in WIP...:)</br>\r\n"
				+ "	</br>\r\n"
				+ "	</br>\r\n"
				+ "	<div style=\"align:center\"><a href=\"/logout\" > Logout </a></div></br>\r\n"
				+ "	</br>\r\n"
				+ "\r\n"
				+ "</p>";
	}
	
	@GetMapping("/employee/getEmployeeById")
	public Employee getEmployeeById(@RequestParam int employeeId) {
		return employeeManager.getEmployeeById(employeeId);
	}
	
	@GetMapping("/employee/getEmployeeByDeptName")
	public List<Employee> getEmployeeByDeptName(@RequestParam String employeeDepartment) {
		return employeeManager.getEmployeeByDeptName(employeeDepartment);
	}
	
	@GetMapping("/employee/getEmployeeByName")
	public List<Employee> getEmployeeByName(@RequestParam String employeeName) {
		return employeeManager.getEmployeeByName(employeeName);
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		return employeeManager.getEmployee(employeeId);
	}

	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return employeeManager.getAllEmployees();
	}
	
	@PostMapping(value="/employee", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String addEmployee(@RequestBody Employee employee) {
		return employeeManager.addEmployee(employee);
	}
	
	@PutMapping(value="/employee/{employeeId}", consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String addEmployee(@RequestBody Employee employee, @PathVariable int employeeId) {
		return employeeManager.updateEmployee(employee, employeeId);
	}
	
	@DeleteMapping (value="/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		return employeeManager.deleteEmployee(employeeId);
	}
	
}

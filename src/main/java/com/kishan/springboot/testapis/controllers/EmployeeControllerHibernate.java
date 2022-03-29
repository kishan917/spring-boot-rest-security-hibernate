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
import com.kishan.springboot.testapis.services.EmployeeManagerHibernate;

@RestController
@RequestMapping("/admin")
public class EmployeeControllerHibernate {
	
	@Autowired
	EmployeeManagerHibernate employeeManagerHibernate;
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeManagerHibernate.getAllEmployees();
	}
	
	@GetMapping("/addRandomEmployee")
	public String addRandomEmployee() {
		return employeeManagerHibernate.addRandomEmployee();
	}

	
}

package com.kishan.springboot.testapis.test;

import java.util.List;

import javax.servlet.http.Cookie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishan.springboot.testapis.entities.Employee;

@RestController
@RequestMapping("/")
public class TestController {
	
	@Autowired
	TestService testService;
	
	
	@GetMapping("/test")
	public String test() {
		
		testService.test();

		return "Testing...";
	}
	
}

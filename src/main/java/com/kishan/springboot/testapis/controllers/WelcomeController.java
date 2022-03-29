package com.kishan.springboot.testapis.controllers;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	
	@GetMapping("/")
	public String welcomePage() {
		
		String welcome = "Welcome to EmployeeController !!";
		String quote = "</br></br><hr><a href=\"/getRandomQuote\" > Thought of the Day </a>";
		String manageEmployees = "</br></br><hr><a href=\"/admin/help\" > Manage Employee </a>";
		String userDetail = "</br></br>Sample user accounts: </br>"
				+ "		username: admin, password: admin, role:AdminRole</br>\r\n"
				+ "		username: user, password: user, role:UserRole</br>\r\n";
		String logout = "</br></br><hr><a href=\"/logout\" > Logout </a></br><hr>";
		
		return "".concat(welcome).concat(quote).concat(manageEmployees).concat(userDetail).concat(logout);
	}
	
	@GetMapping("/getRandomQuote")
	public String getRandomQuote() {
		String[] quotes = {
				"Good, better, best. Never let it rest. Til your good is better and your better is best.",
				"The face is the mirror of the mind, and eyes without speaking confess the secrets of the heart.",
				"Love is not to be purchased, and affection has no price.",
				"Marriage is good for those who are afraid to sleep alone at night.",
				"Keep doing some kind of work, that the devil may always find you employed.",
				"The scars of others should teach us caution.",
				"The friendship that can cease has never been real.",
				"It is not enough for us to restrain from doing evil, unless we shall also do good.",
				"Why do you not practice what you preach.",
				"Someone may ask, &#39;How is justice greater than all the other virtues?&#39; The other virtues gratify the one who possesses them; justice does not give pleasure to the one possessing it, but instead pleases others.",
				"A friend is long sought, hardly found, and with difficulty kept.",
				"A fat stomach never breeds fine thoughts.",
				"Be ever engaged, so that whenever the devil calls he may find you occupied.",
				"Beauty when unadorned is adorned the most.",
				"I am that prodigal son who wasted all the portion entrusted to me by my father. But I have not yet fallen at my father&#39;s knees. I have not yet begun to put away from me the enticements of my former riotous living.",
				"They talk like angels but they live like men.",
				"Being over seventy is like being engaged in a war. All our friends are going or gone and we survive amongst the dead and the dying as on a battlefield.",				
		};
		
		int randomNum = ThreadLocalRandom.current().nextInt(0, quotes.length - 1);
		return quotes[randomNum];
	}
	
	@GetMapping("/greet")
	public String greet() {
		System.out.println("current session id: " + request.getSession().getId());
		response.addCookie(new Cookie("TOKEN", String.valueOf(Math.random()*1000000)));
		return "Hello World";
	}
	
	@PostMapping("/postMessage")
	public String post(@RequestBody String message) {
		return "Posting a message: " + message;
	}
	
}

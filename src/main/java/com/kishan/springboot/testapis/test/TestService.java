package com.kishan.springboot.testapis.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	TestDao testDao;

	public void test() {
		
		testDao.test();
	}

}

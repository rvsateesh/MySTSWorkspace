package com.practice.java.spring.service;

import org.springframework.stereotype.Service;

@Service
public class ServIntImpl implements ServInterface{

	@Override
	public String doGreet(String username) {
		return "Welcome " + username;
	}

}

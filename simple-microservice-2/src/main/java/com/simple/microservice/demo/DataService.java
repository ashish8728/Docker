package com.simple.microservice.demo;

import org.springframework.stereotype.Service;

@Service
public class DataService {
	public String getData() {
		return "This is dummy data.";
	}
}

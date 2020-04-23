package com.simple.microservice.demo;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	public String successMessage() {
		return "Service is working fine.";
	}
}

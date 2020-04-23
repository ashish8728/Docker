package com.simple.microservice.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {

	private RestTemplate restTemplate;

	public MessageService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String successMessage() {
		return "Service is working fine.";
	}

	public String getDataFromOtherService() {
		return restTemplate.getForObject("http://localhost:8080/api/data", String.class);
	}
}

package com.simple.microservice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

	MessageService messageService;
	
	public DemoController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	@GetMapping("/demo")
	public String demo() {
		return messageService.successMessage();
	}
	
	@GetMapping("/data")
	public String data() {
		return messageService.getDataFromOtherService();
	}
}

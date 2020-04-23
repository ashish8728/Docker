package com.simple.microservice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

	private DataService dataService;

	public Controller(DataService dataService) {
		this.dataService = dataService;
	}

	@GetMapping("/data")
	public String data() {
		return dataService.getData();
	}

}

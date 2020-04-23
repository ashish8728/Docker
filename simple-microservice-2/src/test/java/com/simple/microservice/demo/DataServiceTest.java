package com.simple.microservice.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class DataServiceTest {

	@InjectMocks
	private DataService dataService;

	@Test
	void getData_whenNoDataPassed_ReturnDataTest() {
		String data = dataService.getData();
		assertAll(
				() -> assertNotNull(data), 
				() -> assertEquals("This is dummy data.", data)
			);
	}

}

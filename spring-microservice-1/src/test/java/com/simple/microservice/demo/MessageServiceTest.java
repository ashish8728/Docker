package com.simple.microservice.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
class MessageServiceTest {

	@InjectMocks
	MessageService messageService;

	@Mock
	RestTemplate restTemplate;

	@Test
	void successMessageTest() {
		assertEquals("Service is working fine.", messageService.successMessage());
	}

	@Test
	void givenSpringMockServerIsUsed_whenGetDataFromOtherServiceIsCalled_shouldReturnMockedObject() throws Exception {
		String data = null;
		Mockito.when(restTemplate.getForObject("http://localhost:8080/api/data", String.class))
				.thenReturn("data returned from other service");
		data = messageService.getDataFromOtherService();
		assertNotNull(data);
		assertEquals("data returned from other service", data);
	}

}

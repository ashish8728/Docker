package com.simple.microservice.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class MessageServiceTest {

	@InjectMocks
	MessageService messageService;

	@Test
	void successMessageTest() {
		assertEquals("Service is working fine.", messageService.successMessage());
	}

}

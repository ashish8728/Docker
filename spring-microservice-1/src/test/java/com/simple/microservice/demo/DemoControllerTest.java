package com.simple.microservice.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(DemoController.class)
class DemoControllerTest {

	@MockBean
	MessageService messageService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void demo_whenServiceIsUp_resultSuccessMessageTest() throws Exception {
		Mockito.when(messageService.successMessage()).thenReturn("Service is working fine.");
		mockMvc.perform(get("/api/demo").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Service is working fine."));

	}

	@Test
	private void data_whenNoDataIsPassed_andReturnResponseBack() throws Exception {
		Mockito.when(messageService.getDataFromOtherService()).thenReturn("This is data from other service");
		mockMvc.perform(get("/api/data").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.content().string("This is data from other service"));
	}

}

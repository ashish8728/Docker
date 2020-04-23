package com.simple.microservice.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(Controller.class)
class ControllerTest {

	@MockBean
	private DataService dataService;

	@Autowired
	private MockMvc mockMvc;


	@Test
	void data_GivenNoDataPassed_ReturnsDummyDataTest() throws Exception{
		Mockito.when(dataService.getData()).thenReturn("Some Dummy Data.");
		mockMvc.perform(get("/api/data").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Some Dummy Data."));

	}

}

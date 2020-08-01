package com.trucker.Controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trucker.Entity.Reading;
import com.trucker.Repository.TruckerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
			webEnvironment = SpringBootTest.WebEnvironment.MOCK
		)
@AutoConfigureMockMvc
@ActiveProfiles("Testing")
public class ReadingsControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	Reading reading;
	
	@Autowired
	private TruckerRepository truckerRepository;
	
	@After
	public void cleanUp() {
		truckerRepository.DELETE(reading);
	}
	
	@Test
	public void Readings() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		reading = setReadings();
		
		mockMVC.perform(MockMvcRequestBuilders.options("http://localhost:8080/readings")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsBytes(reading))
				.header("Access-Control-Request-Method", "POST")
				.header("Origin", "http://mocker.egen.academy")
				).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	public static Reading setReadings() {
		
		Reading reading = new Reading("1HGCR2F3XFA027534","41.803194","-88.144406",
				"2017-05-25T17:31:25.268Z","1.5","85","240"
				,"false","true","true","6300","34","36","29","34");
		return reading;
	}

}

package com.trucker.Controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.junit.Before;
import org.assertj.core.util.Maps;
import org.hamcrest.Matchers;
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
import com.trucker.Entity.Vehicle;
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
	List<Vehicle> vehicles;
	
	@Autowired
	private TruckerRepository truckerRepository;
	
	@Before
	public void startUp() {
		vehicles = createVehicle();
		reading = createReading();
	}
	
	@After
	public void cleanUp() {
		truckerRepository.removeReading(reading);
		vehicles.forEach((vehicle) -> {
			truckerRepository.removeVehicle(vehicle);
		});
	}
	
	@Test
	public void Readings() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		mockMVC.perform(MockMvcRequestBuilders.options("http://localhost:8080/readings")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsBytes(reading))
				.header("Access-Control-Request-Method", "POST")
				.header("Origin", "http://mocker.egen.academy")
				).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void Vehicle() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		mockMVC.perform(MockMvcRequestBuilders.options("http://localhost:8080/vehicles")
				.contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
				.content(mapper.writeValueAsBytes(vehicles))
				.header("Access-Control-Request-Method", "PUT")
				.header("Origin", "http://mocker.egen.academy")
				).andExpect(MockMvcResultMatchers.status().isOk());
	}

	public static Reading createReading() {
		Map<String,String> tires = new HashMap<>();
		tires.put("Fleft", "34");
		tires.put("Fright", "36");
		tires.put("Rleft", "29");
		tires.put("Rright", "34");
		
		Reading reading = new Reading("1HGCR2F3XFA027534","41.803194","-88.144406",
				"2017-05-25T17:31:25.268Z","1.5","85","240"
				,"false","true","true","6300",tires);
		return reading;
	}
	
	public static List<Vehicle> createVehicle() {
		
		List<Vehicle> list = new ArrayList<>();
		list.add(new Vehicle("1HGCR2F3XFA027534", "HONDA", "ACCORD", "2015", "550", "15", "2017-05-25T17:31:25.268Z"));
		return list;
	}
}

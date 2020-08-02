package com.trucker.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;
import com.trucker.Service.TruckerService;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "http://mocker.egen.academy")
@RestController
public class ReadingsController {
	
	@Autowired
	private TruckerService truckerService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/readings", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reading ReadingsUpdate(@RequestBody Reading reading) {
		return truckerService.putReadings(reading);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/vehicles", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> Vehicle(@RequestBody List<Vehicle> vehicles) {
		for(Vehicle vehicle : vehicles) {
			truckerService.putVehicle(vehicle);
		}
		
		return vehicles;
	}
}

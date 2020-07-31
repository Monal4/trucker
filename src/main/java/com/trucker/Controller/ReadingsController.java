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

import com.trucker.Entity.VehicleReading;
import com.trucker.Service.TruckerService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ReadingsController {
	
	@Autowired
	private TruckerService truckerService;
	
	@CrossOrigin(origins = "http://localhost:8080/readings")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public VehicleReading HelperMapping(@RequestBody VehicleReading vehicle) {
		System.out.println("Inside Controller");
		return truckerService.putReadings(vehicle);
	}
}

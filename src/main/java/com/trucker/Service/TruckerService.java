package com.trucker.Service;

import java.util.List;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;

public interface TruckerService {
	
	void putVehicles(List<Vehicle> vehicles);
	
	Reading putReadings(Reading reading);
	
	void removeReading(Reading reading);
	
	void removeVehicle(Vehicle vehicle);
}

package com.trucker.Repository;

import java.util.List;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;

public interface TruckerRepository {
	
	void putVehicles(List<Vehicle> vehicles);
	
	Reading putReading(Reading reading);
	
	Reading findById(String Id);
	
	void removeReading(Reading reading);
	
	void removeVehicle(Vehicle vehicle);
	
	Vehicle findVehicleById(String Id);
}

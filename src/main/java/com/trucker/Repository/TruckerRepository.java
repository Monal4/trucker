package com.trucker.Repository;

import org.springframework.data.repository.CrudRepository;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;

public interface TruckerRepository {
	
	void putVehicle(Vehicle vehicle);
	
	Reading newReading(Reading reading);
	
	Reading findById(String Id);
	
	void DELETE(Reading reading);
}

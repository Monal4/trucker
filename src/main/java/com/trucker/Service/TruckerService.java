package com.trucker.Service;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;

public interface TruckerService {
	
	void putVehicle(Vehicle vehicle);
	
	Reading putReadings(Reading reading);
	
	void DELETE(Reading reading);
}

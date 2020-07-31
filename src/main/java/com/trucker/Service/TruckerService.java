package com.trucker.Service;

import com.trucker.Entity.VehicleReading;

public interface TruckerService {
	
	void getReadings();
	
	VehicleReading putReadings(VehicleReading V);
}

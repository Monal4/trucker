package com.trucker.Service;

import com.trucker.Entity.Reading;

public interface TruckerService {
	
	void getReadings();
	
	Reading putReadings(Reading reading);
	
	void DELETE(Reading reading);
}

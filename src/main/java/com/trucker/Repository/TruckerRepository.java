package com.trucker.Repository;

import com.trucker.Entity.Reading;

public interface TruckerRepository {
	
	Reading create(Reading reading);
	
	Reading findById(String Id);
	
	void DELETE(Reading reading);
}

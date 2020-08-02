package com.trucker.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;
import com.trucker.Repository.TruckerRepository;

@Service
public class TruckerServiceImpl implements TruckerService {
	
	@Autowired
	private TruckerRepository truckerRepository;
	
	@Transactional
	@Override
	public Reading putReadings(Reading reading) {
		
		return truckerRepository.newReading(reading);	
	}
	
	@Transactional
	@Override
	public void DELETE(Reading reading) {
		
		truckerRepository.DELETE(reading);
	}

	@Transactional
	@Override
	public void putVehicle(Vehicle vehicle) {
		
		truckerRepository.putVehicle(vehicle);
		System.out.println("successfull insert");
	}
	
}

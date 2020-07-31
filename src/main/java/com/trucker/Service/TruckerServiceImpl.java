package com.trucker.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trucker.Entity.VehicleReading;
import com.trucker.Repository.TruckerRepository;

@Service
public class TruckerServiceImpl implements TruckerService {
	
	@Autowired
	private TruckerRepository truckerRepository;
	
	@Transactional
	@Override
	public void getReadings() {
		
		
	}

	@Transactional
	@Override
	public VehicleReading putReadings(VehicleReading V) {
		
		return truckerRepository.create(V);	
	}
	
}

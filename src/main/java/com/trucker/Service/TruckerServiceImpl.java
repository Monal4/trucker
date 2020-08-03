package com.trucker.Service;

import java.util.List;

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
		Vehicle V = truckerRepository.findVehicleById(reading.getVin());
		
		if(V!=null) return truckerRepository.putReading(reading);
		else {
			System.out.println("Inject Vehicles first");
			return new Reading();
		}
	}
	
	@Transactional
	@Override
	public void removeReading(Reading reading) {
		truckerRepository.removeReading(reading);
	}

	@Transactional
	@Override
	public void putVehicles(List<Vehicle> vehicles) {
		
		truckerRepository.putVehicles(vehicles);
	}

	@Transactional
	@Override
	public void removeVehicle(Vehicle vehicle) {
		truckerRepository.removeVehicle(vehicle);
	}
	
}

package com.trucker.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.trucker.Entity.Reading;
import com.trucker.Entity.Vehicle;

@Repository
public class TruckerRepositoryImpl implements TruckerRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Reading putReading(Reading reading) {
		Reading r = entityManager.find(Reading.class, reading.getVin());
		if(r!=null) {
			entityManager.merge(reading);
			return reading;
		}
		entityManager.persist(reading);
		return reading;
	}
	
	@Override
	public void putVehicles(List<Vehicle> vehicles) {
		vehicles.forEach((vehicle) -> {
			Vehicle v = entityManager.find(Vehicle.class, vehicle.getVin());
			if(v!=null) {
				entityManager.merge(vehicle);			
			}
			entityManager.persist(vehicle);
		});
	}
	
	@Override
	public Reading findById(String Id){
		Reading reading = entityManager.find(Reading.class, Id);
		if(reading == null) {
			System.out.println("DAO Exception on FindByID");
		}
		return entityManager.find(Reading.class, Id);
	}

	@Override
	public void removeReading(Reading reading) {
		if(entityManager.contains(reading)) {
			entityManager.remove(reading);
		}
	}

	@Override
	public void removeVehicle(Vehicle vehicle) {
		if(entityManager.contains(vehicle)) {
			entityManager.remove(vehicle);
		}
	}

	@Override
	public Vehicle findVehicleById(String Id) {
		return entityManager.find(Vehicle.class, Id);
	}
}

package com.trucker.Repository;

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
	public Reading newReading(Reading reading) {
		Reading r = entityManager.find(Reading.class, reading.getVin());
		if(r!=null) {
			entityManager.merge(reading);
			return reading;
		}
		entityManager.persist(reading);
		return reading;
	}
	
	@Override
	public void putVehicle(Vehicle vehicle) {
		Vehicle v = entityManager.find(Vehicle.class, vehicle.getVin());
		if(v==null) {
			entityManager.persist(vehicle);
		}else {
			entityManager.merge(vehicle);
		}
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
	public void DELETE(Reading reading) {
		if(entityManager.contains(reading)) {
			entityManager.remove(reading);
		}
	}
}

package com.trucker.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.trucker.Entity.VehicleReading;

@Repository
public class TruckerRepositoryImpl implements TruckerRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public VehicleReading create(VehicleReading vehicle) {
		VehicleReading v = entityManager.find(VehicleReading.class, vehicle.getVin());
		if(v!=null) {
			entityManager.merge(vehicle);
			return vehicle;
		}
		entityManager.persist(vehicle);
		return vehicle;
	}
	
	@Override
	public VehicleReading findById(String Id) {
		return entityManager.find(VehicleReading.class, Id);
	}
}

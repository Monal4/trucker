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
		
		entityManager.persist(vehicle);
		return vehicle;
	}

}

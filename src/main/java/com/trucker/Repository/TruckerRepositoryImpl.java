package com.trucker.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.trucker.Entity.Reading;

@Repository
public class TruckerRepositoryImpl implements TruckerRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Reading create(Reading reading) {
		Reading v = entityManager.find(Reading.class, reading.getVin());
		if(v!=null) {
			entityManager.merge(reading);
			return reading;
		}
		entityManager.persist(reading);
		return reading;
	}
	
	@Override
	public Reading findById(String Id) {
		return entityManager.find(Reading.class, Id);
	}

	@Override
	public void DELETE(Reading reading) {
		if(entityManager.contains(reading)) {
			entityManager.remove(reading);
		}
	}
}

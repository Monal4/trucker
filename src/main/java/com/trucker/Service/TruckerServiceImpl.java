package com.trucker.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trucker.Entity.Reading;
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
	public Reading putReadings(Reading reading) {
		
		return truckerRepository.create(reading);	
	}
	
	@Transactional
	@Override
	public void DELETE(Reading reading) {
		
		truckerRepository.DELETE(reading);
	}
	
}

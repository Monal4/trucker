package com.trucker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	
	@Id
	private String vin;
	
	private String make;
	private String model;
	private String year;
	private String redlineRpm;
	private String maxFuelVolume;
	private String lastServiceDate;
	
	@OneToOne
	private Reading reading;
	
	public Vehicle() {}
	
	public Vehicle(String vin, String make, String model, String year, String redlineRpm, String maxFuelVolume,
			String lastServiceDate) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.redlineRpm = redlineRpm;
		this.maxFuelVolume = maxFuelVolume;
		this.lastServiceDate = lastServiceDate;
	}

	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getRedlineRpm() {
		return redlineRpm;
	}
	
	public void setRedlineRpm(String redlineRpm) {
		this.redlineRpm = redlineRpm;
	}
	
	public String getMaxFuelVolume() {
		return maxFuelVolume;
	}
	
	public void setMaxFuelVolume(String maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
	
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}
}

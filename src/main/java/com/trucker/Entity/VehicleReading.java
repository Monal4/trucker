package com.trucker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleReading {
	
	@Id
	String vin;
	
	String make;
	String model;
	String year;
	String redlineRpm;
	String maxFuelVolume;
	String lastServiceDate;
	
	public String getVin() {
		return vin;
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

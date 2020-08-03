package com.trucker.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reading {
	
	@Id
	private String vin;
	
	private String latitude;
	private String longitude;
	private String timestamp;
	private String fuelVolume;
	private String speed;
	private String engineHp;
	private String checkEngineLightOn;
	private String engineCoolantLow;
	private String cruiseControlOn;
	private String engineRpm;
	
	@ElementCollection
	Map<String,String> tires = new HashMap<>();
	
	public Reading() {}
	
	public Reading(String vin, String latitude, String longitude, String timestamp, String fuelVolume, String speed,
			String engineHp, String checkEngineLightOn, String engineCoolantLow, String cruiseControlOn,
			String engineRpm, Map<String, String> tires) {
		this.vin = vin;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
		this.fuelVolume = fuelVolume;
		this.speed = speed;
		this.engineHp = engineHp;
		this.checkEngineLightOn = checkEngineLightOn;
		this.engineCoolantLow = engineCoolantLow;
		this.cruiseControlOn = cruiseControlOn;
		this.engineRpm = engineRpm;
		this.tires = tires;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(String fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(String engineHp) {
		this.engineHp = engineHp;
	}

	public String getCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(String checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public String getEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(String engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public String getCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(String cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	public String getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(String engineRpm) {
		this.engineRpm = engineRpm;
	}

	public Map<String,String> getTires() {
		return tires;
	}
	
	public void setTires(Map<String, String> tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		return "{"
				+ "vin=" + vin 
				+ ", latitude=" + latitude 
				+ ", longitude=" + longitude 
				+ ", timestamp=" + timestamp 
				+ ", fuelVolume=" + fuelVolume 
				+ ", speed=" + speed 
				+ ", engineHp=" + engineHp
				+ ", checkEngineLightOn=" + checkEngineLightOn 
				+ ", engineCoolantLow=" + engineCoolantLow
				+ ", cruiseControlOn=" + cruiseControlOn 
				+ ", engineRpm=" + engineRpm 
				+ ", tires=" + tires 
			+ "}";
	}
	
}

package es.upm.grise.PROF_2020_EXFINAL;

import static es.upm.grise.PROF_2020_EXFINAL.FurnaceStatus.*;

public class Furnace {
	
	private TemperatureSensor sensor;
	
	/*
	 * public Furnace() { sensor = new TemperatureSensor(); }
	 */
	
	public Furnace(TemperatureSensor sensor) {
		this.sensor = sensor;
	}
	
	public FurnaceStatus checkStatus() {
		
		FurnaceStatus furnaceStatus = null;
		
		try {
			// Read the current temperature
			float currentTemperature = sensor.readTemperature();
			
			// Return the current situation
			if(currentTemperature <= 100) 
				furnaceStatus = UNDER_HEATED;
			if(currentTemperature > 100 && currentTemperature <= 200) 
				furnaceStatus = CORRECT_TEMPERATURE;
			if(currentTemperature > 200) 
				furnaceStatus = OVER_HEATED;	
			
		} catch (CannotReadTemperatureException e) {
			furnaceStatus = SENSOR_ERROR;
		}
		
		return furnaceStatus;
		
	}

}

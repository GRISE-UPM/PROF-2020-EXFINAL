package es.upm.grise.PROF_2020_EXFINAL;

import static es.upm.grise.PROF_2020_EXFINAL.FurnaceStatus.*;
import static org.junit.Assert.assertEquals;

import static org.mockito.BDDMockito.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

public class SmokeTest {
	/*
	@Test
	public void currentCodeRuns() {
		
		Furnace furnace = new Furnace();
		assertEquals(UNDER_HEATED, furnace.checkStatus());
	}
*/
	@Test
	public void underHeatedTest() throws CannotReadTemperatureException{
		
		TemperatureSensor temperatureSensorEjemplo = mock(TemperatureSensor.class);
		when(temperatureSensorEjemplo.readTemperature()).thenReturn(90.0f);
		
		Furnace furnaceEjemplo = new Furnace();		
		furnaceEjemplo.sensor = temperatureSensorEjemplo;

		
		assertEquals(UNDER_HEATED, furnaceEjemplo.checkStatus());
	}
	
	@Test
	public void correctTemperatureTest() throws CannotReadTemperatureException{
		
		TemperatureSensor temperatureSensorEjemplo = mock(TemperatureSensor.class);
		when(temperatureSensorEjemplo.readTemperature()).thenReturn(150.0f);
		
		Furnace furnaceEjemplo = new Furnace();		
		furnaceEjemplo.sensor = temperatureSensorEjemplo;
	
		assertEquals(CORRECT_TEMPERATURE, furnaceEjemplo.checkStatus());
	}
	
	@Test
	public void overHeatedTest() throws CannotReadTemperatureException{
		
		TemperatureSensor temperatureSensorEjemplo = mock(TemperatureSensor.class);
		when(temperatureSensorEjemplo.readTemperature()).thenReturn(250.0f);
		
		Furnace furnaceEjemplo = new Furnace();		
		furnaceEjemplo.sensor = temperatureSensorEjemplo;
	
		assertEquals(OVER_HEATED, furnaceEjemplo.checkStatus());
	}
	
	@Test
	public void CannotReadTemperatureTest() throws CannotReadTemperatureException{
		
		TemperatureSensor temperatureSensorEjemplo = mock(TemperatureSensor.class);
		when(temperatureSensorEjemplo.readTemperature()).thenThrow(CannotReadTemperatureException.class);
		
		Furnace furnaceEjemplo = new Furnace();		
		furnaceEjemplo.sensor = temperatureSensorEjemplo;
		assertEquals(SENSOR_ERROR, furnaceEjemplo.checkStatus());
	}
}

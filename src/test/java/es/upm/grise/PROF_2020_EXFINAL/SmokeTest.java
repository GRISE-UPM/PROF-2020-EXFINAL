package es.upm.grise.PROF_2020_EXFINAL;

import static es.upm.grise.PROF_2020_EXFINAL.FurnaceStatus.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class SmokeTest {
	
	TemperatureSensor sensorMock; //dependency 
	Furnace furnace; //SUT

	@Before 
	public void setup() { 
		sensorMock = mock(TemperatureSensor.class);
		furnace = new Furnace(sensorMock);
	}
		
	/*
	@Test 
	public void currentCodeRuns() {
  
		Furnace furnace = new Furnace(); 
		assertEquals(UNDER_HEATED,furnace.checkStatus()); 
	}
	*/
	
	@Test
	public void furnaceUnderHeated() throws CannotReadTemperatureException {
		when(sensorMock.readTemperature()).thenReturn(100F); //uso valor frontera, con valor menor que 100 también funciona
		assertEquals(UNDER_HEATED,furnace.checkStatus());
	}
	
	@Test
	public void furnaceCorrectTemperature() throws CannotReadTemperatureException {
		when(sensorMock.readTemperature()).thenReturn(200F);//uso valor frontera
		assertEquals(CORRECT_TEMPERATURE,furnace.checkStatus());
	}	

	@Test
	public void furnaceOverHeated() throws CannotReadTemperatureException {
		when(sensorMock.readTemperature()).thenReturn(250F);
		assertEquals(OVER_HEATED,furnace.checkStatus());
	}
	
	@Test
	public void errorCantReadTemperature() throws CannotReadTemperatureException {
		when(sensorMock.readTemperature()).thenThrow(new CannotReadTemperatureException());
		assertEquals(SENSOR_ERROR,furnace.checkStatus());
	}
	
}

package es.upm.grise.PROF_2020_EXFINAL;

import static es.upm.grise.PROF_2020_EXFINAL.FurnaceStatus.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
//import static org.mockito.Mockito.*;
//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SmokeTest {
	
	/*@Test
	public void currentCodeRuns() {
		
		Furnace furnace = new Furnace();
		assertEquals(UNDER_HEATED, furnace.checkStatus());
	}*/ 
	
	private TemperatureSensor tempSens;
	private Furnace furnace;
	
	@Before
	public void setup() {
		
		tempSens = mock(TemperatureSensor.class);	
		furnace = new Furnace();
		furnace.sensor = tempSens;
	}
	
	@Test
	public void check_UNDER_HEATED() throws CannotReadTemperatureException {
		
		when(tempSens.readTemperature()).thenReturn(99.5f);
		assertEquals(UNDER_HEATED, furnace.checkStatus());
	}
	
	@Test
	public void check_CORRECT_TEMPERATURE() throws CannotReadTemperatureException {
		
		when(tempSens.readTemperature()).thenReturn(199.5f);
		assertEquals(CORRECT_TEMPERATURE, furnace.checkStatus());
	}
	
	@Test
	public void check_OVER_HEATED() throws CannotReadTemperatureException {
		
		when(tempSens.readTemperature()).thenReturn(299.5f);
		assertEquals(OVER_HEATED, furnace.checkStatus());
	}
	
	@Test
	public void check_SENSOR_ERROR() throws CannotReadTemperatureException {
		
		when(tempSens.readTemperature()).thenThrow(CannotReadTemperatureException.class);
		assertEquals(SENSOR_ERROR, furnace.checkStatus());
	}
}

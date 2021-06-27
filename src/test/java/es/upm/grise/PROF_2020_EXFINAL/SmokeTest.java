package es.upm.grise.PROF_2020_EXFINAL;

import static es.upm.grise.PROF_2020_EXFINAL.FurnaceStatus.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmokeTest {
	
	@Test
	public void currentCodeRuns() {
		
		Furnace furnace = new Furnace();
		assertEquals(UNDER_HEATED, furnace.checkStatus());
	}

}

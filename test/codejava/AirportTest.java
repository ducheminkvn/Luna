package codejava;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AirportTest {
	private Airport airport = new Airport("6452", "AB24", "inter", "testAir", "",
			"", "", "europe", "FR",
			"", "Paris", "", "",
			"", "", "", "", "");

	
	@Test(expected = NullPointerException.class)
	public void testNullException() {
		new Airport(null, "AB24", "inter", "testAir", "",
				"", "", "europe", "FR",
				"", "Paris", "", "",
				"", "", "", "", "");
	}

	@Test
	public void getIsoCountry() {
		assertEquals("FR",airport.getIso_country());
	}
	
	@Test
	public void getId() {
		assertEquals("6452",airport.getId());
	}
	
	@Test
	public void getIdent() {
		assertEquals("AB24",airport.getIdent());
	}
}

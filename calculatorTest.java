import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class calculatorTest {
	
	@Test
	void population() {
		double result = Calculator2.evaluate("10,20,30,40");
		double expectedresult = 11.180339887499;
		assertEquals(expectedresult, result);
	}
	@Test
	void population_decimal() {
		double result = Calculator2.evaluate("10,20.5,30,40.5");
		double expectedresult = 11.294356998077;
		assertEquals(expectedresult, result);
	}

	
	@Test
	void sample() {
		double result = Calculator2.evaluatesample("10,20,30,40");
		double expectedresult = 12.909944487358;
		assertEquals(expectedresult, result);
	}
	
	@Test
	void sample_decimal() {
		double result = Calculator2.evaluatesample("10,20.5,30,40.5");
		double expectedresult = 13.041600106326;
		assertEquals(expectedresult, result);
	}
	
	
	

}

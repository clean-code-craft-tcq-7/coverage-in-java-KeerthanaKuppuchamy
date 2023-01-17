package TypewiseAlert;

import static org.junit.Assert.*;

import org.junit.Test;

import TypewiseAlert.ClassifyTemperatureBreach;
import TypewiseAlert.EBreachType;
import TypewiseAlert.ECoolingType;

public class ClassifyTemperatureBreachTest {

	@Test
	public void infersBreachAsPerLimits() {
		assertTrue(ClassifyTemperatureBreach.inferBreach(12, 20, 30) == EBreachType.TOO_LOW);
		assertTrue(ClassifyTemperatureBreach.inferBreach(20, 20, 30) == EBreachType.NORMAL);
		assertTrue(ClassifyTemperatureBreach.inferBreach(30, 20, 30) == EBreachType.NORMAL);
		assertTrue(ClassifyTemperatureBreach.inferBreach(31, 20, 30) == EBreachType.TOO_HIGH);
	}

	@Test
	public void testClassifyTemperatureBreach() {
		assertTrue(ClassifyTemperatureBreach.classifyTemperatureBreach(ECoolingType.PASSIVE_COOLING,
				10) == EBreachType.NORMAL);
	}
}

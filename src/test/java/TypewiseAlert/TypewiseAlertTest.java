package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest {

	@Test
	public void testCheckAndAlert() {
		// assert alert for too high temperature - Email
		BatteryCharacter batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.HI_ACTIVE_COOLING);
		EAlertTarget alertTarget = EAlertTarget.TO_EMAIL;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 60));

		// assert alert for too low temperature - Email
		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1));

		// assert for normal temperature - Email
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 20));

		// assert alert for too low temperature - Controller
		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.PASSIVE_COOLING);
		alertTarget = EAlertTarget.TO_CONTROLLER;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1));

	}
}

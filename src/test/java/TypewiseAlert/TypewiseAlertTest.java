package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypewiseAlertTest {

	@Test
	public void testCheckAndAlert() {
		BatteryCharacter batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.HI_ACTIVE_COOLING);
		EAlertTarget alertTarget = EAlertTarget.TO_EMAIL;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 60));

		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.PASSIVE_COOLING);
		alertTarget = EAlertTarget.TO_CONTROLLER;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1));

		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		alertTarget = EAlertTarget.TO_EMAIL;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1));

		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		alertTarget = EAlertTarget.TO_EMAIL;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 20));

	}
}

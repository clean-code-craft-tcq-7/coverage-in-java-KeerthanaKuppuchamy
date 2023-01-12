package TypewiseAlert;

import static org.junit.Assert.assertFalse;
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

		// assert for normal temperature - Email - will not be sent
		assertFalse(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 20));

		// assert alert for too low temperature - Controller
		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.PASSIVE_COOLING);
		alertTarget = EAlertTarget.TO_CONTROLLER;
		assertTrue(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1));

		alertTarget = EAlertTarget.NO_ALERT;
		assertFalse(TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1));
	}

	@Test
	public void testSendToController() {
		assertTrue(TypewiseAlert.sendToController(EBreachType.NORMAL));
	}

	@Test
	public void testSendToEmail() {

		// alert for too high temperature
		assertTrue(TypewiseAlert.sendToEmail(EBreachType.TOO_HIGH));

		// no alert for normal scenarios
		assertFalse(TypewiseAlert.sendToEmail(EBreachType.NORMAL));

	}

}

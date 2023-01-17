package TypewiseAlert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TypewiseAlertTest {

	@Test
	public void testCheckAndAlert() {

		// assert alert for too high temperature - Controller
		BatteryCharacter batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.HI_ACTIVE_COOLING);
		EAlertTarget alertTarget = EAlertTarget.TO_EMAIL;
		FakeBreachAlerter breachAlerter = new FakeBreachAlerter();
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 60, breachAlerter);
		assertEquals(1, breachAlerter.invokeEmailCount);

		// assert alert for too low temperature - Email
		breachAlerter = new FakeBreachAlerter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		alertTarget = EAlertTarget.TO_EMAIL;
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1, breachAlerter);
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1, breachAlerter);
		assertEquals(2, breachAlerter.invokeEmailCount);

		// assert alert for too low temperature - Controller
		breachAlerter = new FakeBreachAlerter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		alertTarget = EAlertTarget.TO_CONTROLLER;
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1, breachAlerter);
		assertEquals(1, breachAlerter.invokeCountrollerCount);
	}
}

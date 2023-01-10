package TypewiseAlert;

import org.junit.Test;

import TypewiseAlert.BatteryCharacter;
import TypewiseAlert.EAlertTarget;
import TypewiseAlert.ECoolingType;
import TypewiseAlert.TypewiseAlert;

public class TypewiseAlertTest {

	@Test
	public void testCheckAndAlert() {
		BatteryCharacter batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.HI_ACTIVE_COOLING);
		EAlertTarget alertTarget = EAlertTarget.TO_EMAIL;
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 60);

		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.PASSIVE_COOLING);
		alertTarget = EAlertTarget.TO_CONTROLLER;
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1);

		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		alertTarget = EAlertTarget.TO_EMAIL;
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, -1);

		batteryCharacter = new BatteryCharacter();
		batteryCharacter.setCoolingType(ECoolingType.MED_ACTIVE_COOLING);
		alertTarget = EAlertTarget.TO_EMAIL;
		TypewiseAlert.checkAndAlert(alertTarget, batteryCharacter, 20);

	}
}

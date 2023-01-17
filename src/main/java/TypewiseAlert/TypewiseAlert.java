package TypewiseAlert;

public class TypewiseAlert {

	public static void checkAndAlert(EAlertTarget alertTarget, BatteryCharacter batteryCharacter, double temperatureInC,
			IBreachAlerter breachAlerter) {

		EBreachType breachType = ClassifyTemperatureBreach.classifyTemperatureBreach(batteryCharacter.coolingType,
				temperatureInC);

		if (alertTarget.equals(EAlertTarget.TO_CONTROLLER)) {
			breachAlerter.sendToController(breachType);
		} else if (alertTarget.equals(EAlertTarget.TO_EMAIL)) {
			breachAlerter.sendToEmail(breachType);
		}
	}

}

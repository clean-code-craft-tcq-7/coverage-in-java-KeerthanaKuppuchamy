package TypewiseAlert;

public class TypewiseAlert {

	private static final String TEMPERATURE_TOO_LOW_MESSAGE = "Hi, the temperature is too low";
	private static final String TEMPERATURE_TOO_HIGH_MESSAGE = "Hi, the temperature is too high";
	public static final String recepient = "a.b@c.com";

	public static boolean checkAndAlert(EAlertTarget alertTarget, BatteryCharacter batteryCharacter,
			double temperatureInC) {

		boolean targetAlerted = false;
		EBreachType breachType = ClassifyTemperatureBreach.classifyTemperatureBreach(batteryCharacter.coolingType,
				temperatureInC);

		switch (alertTarget) {
		case TO_CONTROLLER:
			sendToController(breachType);
			targetAlerted = true;
			break;
		case TO_EMAIL:
			sendToEmail(breachType);
			targetAlerted = true;
			break;
		}
		return targetAlerted;
	}

	public static void sendToController(EBreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%s : %s\n", header, breachType);
	}

	public static void sendToEmail(EBreachType breachType) {
		if (breachType.equals(EBreachType.TOO_HIGH)) {
			alertViaEmail(TEMPERATURE_TOO_HIGH_MESSAGE);
		} else if (breachType.equals(EBreachType.TOO_LOW)) {
			alertViaEmail(TEMPERATURE_TOO_LOW_MESSAGE);
		}
	}

	public static void alertViaEmail(String message) {
		System.out.printf("To: %s\n", recepient);
		System.out.println(message);
	}
}

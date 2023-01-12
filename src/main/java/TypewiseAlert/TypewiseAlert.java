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

		if (alertTarget.equals(EAlertTarget.TO_CONTROLLER)) {
			targetAlerted = sendToController(breachType);
		} else if (alertTarget.equals(EAlertTarget.TO_EMAIL)) {
			targetAlerted = sendToEmail(breachType);
		}
		return targetAlerted;
	}

	public static boolean sendToController(EBreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%s : %s\n", header, breachType);
		return true;
	}

	public static boolean sendToEmail(EBreachType breachType) {
		boolean targetAlerted = false;
		if (breachType.equals(EBreachType.TOO_HIGH)) {
			alertViaEmail(TEMPERATURE_TOO_HIGH_MESSAGE);
			targetAlerted = true;
		} else if (breachType.equals(EBreachType.TOO_LOW)) {
			alertViaEmail(TEMPERATURE_TOO_LOW_MESSAGE);
			targetAlerted = true;
		}
		return targetAlerted;
	}

	public static void alertViaEmail(String message) {
		System.out.printf("To: %s\n", recepient);
		System.out.println(message);
	}
}

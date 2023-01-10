package TypewiseAlert;

public class TypewiseAlert {

	public static void checkAndAlert(EAlertTarget alertTarget, BatteryCharacter batteryCharacter,
			double temperatureInC) {

		EBreachType breachType = ClassifyTemperatureBreach.classifyTemperatureBreach(batteryCharacter.coolingType,
				temperatureInC);

		switch (alertTarget) {
		case TO_CONTROLLER:
			sendToController(breachType);
			break;
		case TO_EMAIL:
			sendToEmail(breachType);
			break;
		}
	}

	public static void sendToController(EBreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%s : %s\n", header, breachType);
	}

	public static void sendToEmail(EBreachType breachType) {
		String recepient = "a.b@c.com";
		switch (breachType) {
		case TOO_LOW:
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is too low\n");
			break;
		case TOO_HIGH:
			System.out.printf("To: %s\n", recepient);
			System.out.println("Hi, the temperature is too high\n");
			break;
		case NORMAL:
			break;
		}
	}
}

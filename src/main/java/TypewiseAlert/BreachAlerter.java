package TypewiseAlert;

public class BreachAlerter implements IBreachAlerter {

	private static final String TEMPERATURE_TOO_LOW_MESSAGE = "Hi, the temperature is too low";
	private static final String TEMPERATURE_TOO_HIGH_MESSAGE = "Hi, the temperature is too high";
	public static final String recepient = "a.b@c.com";

	public void sendToController(EBreachType breachType) {
		int header = 0xfeed;
		System.out.printf("%s : %s\n", header, breachType);
	}

	public void sendToEmail(EBreachType breachType) {
		if (breachType.equals(EBreachType.TOO_HIGH)) {
			alertViaEmail(TEMPERATURE_TOO_HIGH_MESSAGE);
		} else if (breachType.equals(EBreachType.TOO_LOW)) {
			alertViaEmail(TEMPERATURE_TOO_LOW_MESSAGE);
		}
	}

	public void alertViaEmail(String message) {
		System.out.printf("To: %s\n", recepient);
		System.out.println(message);
	}
}

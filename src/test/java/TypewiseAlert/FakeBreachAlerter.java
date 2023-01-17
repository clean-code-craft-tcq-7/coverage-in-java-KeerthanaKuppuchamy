package TypewiseAlert;

public class FakeBreachAlerter implements IBreachAlerter {

	public int invokeCountrollerCount = 0;
	public int invokeEmailCount = 0;

	public void sendToController(EBreachType breachType) {
		invokeCountrollerCount++;
	}

	public void sendToEmail(EBreachType breachType) {
		invokeEmailCount++;
	}

}

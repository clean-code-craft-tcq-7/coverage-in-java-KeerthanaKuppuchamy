package TypewiseAlert;

public interface IBreachAlerter {

	void sendToController(EBreachType breachType);

	void sendToEmail(EBreachType breachType);
}

package TypewiseAlert;

public class ClassifyTemperatureBreach {

	public static EBreachType inferBreach(double value, double lowerLimit, double upperLimit) {
		if (value < lowerLimit) {
			return EBreachType.TOO_LOW;
		}
		if (value > upperLimit) {
			return EBreachType.TOO_HIGH;
		}
		return EBreachType.NORMAL;
	}

	public static EBreachType classifyTemperatureBreach(ECoolingType coolingType, double temperatureInC) {
		return inferBreach(temperatureInC, coolingType.lowerLimit, coolingType.upperLimit);
	}
}

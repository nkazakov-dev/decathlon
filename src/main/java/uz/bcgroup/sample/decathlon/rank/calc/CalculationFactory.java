package uz.bcgroup.sample.decathlon.rank.calc;

public class CalculationFactory {
	public static Calculation newCalculation() {
		return new CalculationImpl();
	}
}

package uz.bcgroup.sample.decathlon.rank.calc;

import java.math.BigDecimal;
import java.util.function.Function;

import uz.bcgroup.sample.decathlon.common.Event;

public class CalculationImpl implements Calculation{

	private Formula formula;
	
	public CalculationImpl() {
		this.formula = new Formula();
	}

	@Override
	public Integer calcPoint(Event event, BigDecimal score) {
		Function<BigDecimal, Integer> currentformula = formula.getByEvent(event);
		return currentformula.apply(score);
	}
}

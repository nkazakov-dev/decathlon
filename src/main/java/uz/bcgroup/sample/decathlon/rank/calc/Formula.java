package uz.bcgroup.sample.decathlon.rank.calc;

import java.math.BigDecimal;
import java.util.function.Function;

import uz.bcgroup.sample.decathlon.common.Event;

public class Formula {
	
	public Formula() {
		super();
	}

	public Function<BigDecimal, Integer> getByEvent(Event event){
		Function<BigDecimal, Integer> func = null;
		
		Rate rate = RateContainer.getInstance().getRateByEvent(event);
		
		switch(event) {
			case HUNDRED_M:
			case FOUR_HUNDRED_M:
			case HUNDRED_TEN_M:
			case THOUSAND_FIVE_HUNDRED_M:
				func = (scored) -> {
					if(scored == null) {
						throw new  IllegalArgumentException("scored cannot be empty");
					}
					
					double powed = Math.pow(rate.getRateB().subtract(scored).doubleValue(), rate.getRateC().doubleValue());
					return (int) (powed * rate.getRateA().doubleValue());	
				};
				break;
			default:
				func = (scored) -> {
					if(scored == null) {
						throw new  IllegalArgumentException("scored cannot be empty");
					}
					
					double powed = Math.pow(scored.subtract(rate.getRateB()).doubleValue(), rate.getRateC().doubleValue());
					return (int) (powed * rate.getRateA().doubleValue());	
				};
				break;
		}
		
		return func;	
	}
}

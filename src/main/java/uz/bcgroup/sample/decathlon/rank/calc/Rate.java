package uz.bcgroup.sample.decathlon.rank.calc;

import java.math.BigDecimal;

import uz.bcgroup.sample.decathlon.common.Event;

public class Rate {

	private Event event;
	private BigDecimal rateA;
	private BigDecimal rateB;
	private BigDecimal rateC;
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event eventType) {
		this.event = eventType;
	}
	public BigDecimal getRateA() {
		return rateA;
	}
	public void setRateA(BigDecimal rateA) {
		this.rateA = rateA;
	}
	public BigDecimal getRateB() {
		return rateB;
	}
	public void setRateB(BigDecimal rateB) {
		this.rateB = rateB;
	}
	public BigDecimal getRateC() {
		return rateC;
	}
	public void setRateC(BigDecimal rateC) {
		this.rateC = rateC;
	}	
	
}

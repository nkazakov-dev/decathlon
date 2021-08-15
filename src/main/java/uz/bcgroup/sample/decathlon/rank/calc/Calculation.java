package uz.bcgroup.sample.decathlon.rank.calc;

import java.math.BigDecimal;

import uz.bcgroup.sample.decathlon.common.Event;

public interface Calculation {

	Integer calcPoint(Event event, BigDecimal score) ;
}

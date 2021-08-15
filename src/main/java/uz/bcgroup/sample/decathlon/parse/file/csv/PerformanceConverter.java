package uz.bcgroup.sample.decathlon.parse.file.csv;

import java.math.BigDecimal;

import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.common.Performance;
import uz.bcgroup.sample.decathlon.util.NumberUtil;

public class PerformanceConverter {
	
	public static Performance convert(Event event, String score) {
		Performance perf = new Performance();
		perf.setEvent(event);
		perf.setOriginalScore(score);
		
		score = score.strip();
		
		switch(event) {
			case HUNDRED_M:
			case FOUR_HUNDRED_M:
			case HUNDRED_TEN_M:{
				// must be in seconds
				perf.setScore(NumberUtil.parseBigDecimal(score));
				
				break;
			}
			case LONG_JUMP:
			case HIGH_JUMP:
			case POLE_VAULT:{
				//must be in centimetres 
				perf.setScore(NumberUtil.parseBigDecimal(score).multiply(new BigDecimal(100)));
				break;
			}
			case SHOT_PUT:
			case DISCUS_THROW:
			case JAVELIN_THROW: {
				//must be in metres 
				perf.setScore(NumberUtil.parseBigDecimal(score));
				break;
			}		
			case THOUSAND_FIVE_HUNDRED_M: {
				// must be in seconds, given format is 3.23.55
				String[] pieces = score.split("\\.");
				
				BigDecimal sc = NumberUtil.parseBigDecimal(Integer.parseInt(pieces[0]) * 60 + Integer.parseInt(pieces[1]));
				sc = sc.add(NumberUtil.parseBigDecimal("0." + pieces[2]));
				
				perf.setScore(sc);
				break;
			}
		}
		
		return perf;
	}
}

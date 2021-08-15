package uz.bcgroup.sample.decathlon.parse.file.csv;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.common.Performance;

public class AthleteConverter {
	private static Logger log = Logger.getLogger(AthleteConverter.class.getName());
	
	public static Athlete convert(String[] cols) {
		if(cols.length != 11) {
			log.severe("Cols: " + cols.toString());
			throw new IllegalArgumentException("Column length is not correct");				
		}
		
		Athlete at = new Athlete();
		List<Performance> performances = new ArrayList<Performance>();
		
		//name
		at.setName(cols[0]);
		
		//100m
		performances.add(PerformanceConverter.convert(Event.HUNDRED_M, cols[1]));
		
		//Long jump
		performances.add(PerformanceConverter.convert(Event.LONG_JUMP, cols[2]));
		
		//Shot put
		performances.add(PerformanceConverter.convert(Event.SHOT_PUT, cols[3]));
		
		//High jump
		performances.add(PerformanceConverter.convert(Event.HIGH_JUMP, cols[4]));
		
		//400 m
		performances.add(PerformanceConverter.convert(Event.FOUR_HUNDRED_M, cols[5]));
		
		//110 m hurdles
		performances.add(PerformanceConverter.convert(Event.HUNDRED_TEN_M, cols[6]));
		
		//Discus throw
		performances.add(PerformanceConverter.convert(Event.DISCUS_THROW, cols[7]));
		
		//Pole vault
		performances.add(PerformanceConverter.convert(Event.POLE_VAULT, cols[8]));
		
		//Javelin throw
		performances.add(PerformanceConverter.convert(Event.JAVELIN_THROW, cols[9]));
		
		//1500 m
		performances.add(PerformanceConverter.convert(Event.THOUSAND_FIVE_HUNDRED_M, cols[10]));
		
		at.setPerformances(performances);
		
		return at;
	}

}

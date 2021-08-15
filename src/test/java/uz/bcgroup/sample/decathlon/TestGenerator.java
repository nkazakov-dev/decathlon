package uz.bcgroup.sample.decathlon;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.common.Performance;

public class TestGenerator {

	public static Athlete getTestRandomAthlete() {
		Athlete at = new Athlete();
		at.setName(UUID.randomUUID().toString());
		at.setSecretId(UUID.randomUUID().toString());
		at.setPerformances(getTestRandomPerformances());
		
		return at;
	}
	
	public static List<Performance> getTestRandomPerformances(){
		SecureRandom r = new SecureRandom();
		return Stream.of(Event.values())
			.map(e -> {
				double randVal = 10D + 100 * r.nextDouble();				
				return new Performance(e, new BigDecimal(randVal), String.valueOf(randVal));
			})
			.collect(Collectors.toList());
	}
	
}

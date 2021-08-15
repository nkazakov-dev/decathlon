package uz.bcgroup.sample.decathlon.common;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AthleteSorter {

	public static List<Athlete> sortDescendByPosition(List<Athlete> athletes){
		
		Comparator<Athlete> decendOrder = (a1, a2) -> {
			if( !a1.getPosition().getMinPosition().equals(a2.getPosition().getMinPosition())) {
				// smaller position on top
				return a1.getPosition().getMinPosition().compareTo(a2.getPosition().getMinPosition());
			}else {
				// name must be natural order
				return a1.getName().compareTo(a2.getName());
			}				
		};
		
		return athletes.stream().sorted(decendOrder).collect(Collectors.toUnmodifiableList());	
	}
}

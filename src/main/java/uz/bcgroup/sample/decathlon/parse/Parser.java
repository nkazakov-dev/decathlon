package uz.bcgroup.sample.decathlon.parse;

import java.util.List;

import uz.bcgroup.sample.decathlon.common.Athlete;

public interface Parser<T> {

	List<Athlete> parse(T input);
	
}

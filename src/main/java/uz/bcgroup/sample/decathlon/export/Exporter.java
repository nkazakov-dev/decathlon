package uz.bcgroup.sample.decathlon.export;

import java.util.List;

import uz.bcgroup.sample.decathlon.common.Athlete;

public interface Exporter<T> {

	void export(List<Athlete> athletes, T output);
}

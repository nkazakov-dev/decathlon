package uz.bcgroup.sample.decathlon.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Athlete {
	
	private String name;
	private List<Performance> performances = new ArrayList<Performance>();
	private String secretId;
	private Position position;
	
	public Athlete() {
		super();
		this.secretId = UUID.randomUUID().toString();
	}
	
	public Athlete(String name, List<Performance> performances, String secretId) {
		super();
		this.name = name;
		this.performances = performances;
		this.secretId = secretId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Performance findPerformanceByEvent(Event event) {
		Optional<Performance> found = performances.stream().filter(p -> p.getEvent().equals(event)).findFirst();
		
		if(found.isPresent()) {
			return found.get();
		}
		
		return null;
	}
	
	public List<Performance> getPerformances() {
		return performances;
	}

	public void setPerformances(List<Performance> performances) {
		this.performances = performances;
	}

	
	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Athlete [name=" + name + ", performances=" + performances + ", secretId="
				+ secretId + "]";
	}

	
}

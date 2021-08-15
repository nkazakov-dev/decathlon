package uz.bcgroup.sample.decathlon.common;

import java.math.BigDecimal;

public class Performance {

	private Event event;
	private BigDecimal score;
	private String originalScore;
	
	public Performance() {
		super();
	}
	
	public Performance(Event event, BigDecimal score, String originalScore) {
		super();
		this.event = event;
		this.score = score;
		this.originalScore = originalScore;
	}

	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public String getOriginalScore() {
		return originalScore;
	}
	public void setOriginalScore(String originalScore) {
		this.originalScore = originalScore;
	}
	@Override
	public String toString() {
		return "Performance [event=" + event + ", score=" + score + ", originalScore=" + originalScore + "]";
	}
	
}

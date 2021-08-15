package uz.bcgroup.sample.decathlon.common;

public enum Event {
	HUNDRED_M("100 m"),
	LONG_JUMP("Long jump"),
	SHOT_PUT("Shot put"),
	HIGH_JUMP("High jump"),
	FOUR_HUNDRED_M("400 m"),
	HUNDRED_TEN_M("110 m hurdles"),
	DISCUS_THROW("Discus throw"),
	POLE_VAULT("Pole vault"),
	JAVELIN_THROW("Javelin throw"),
	THOUSAND_FIVE_HUNDRED_M("1500 m")
	;
	
	private String text;

	private Event(String text) {
		this.text = text;
	}
	
	public String text() {
		return text;
	}
}

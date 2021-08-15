package uz.bcgroup.sample.decathlon.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.common.Performance;
import uz.bcgroup.sample.decathlon.parse.file.csv.PerformanceConverter;

public class PerformanceConverterTest {

	
	@BeforeEach
	public void setUp() {
	}
	
	@Test
    public void checkMeterTypeConverting() {
		
		Performance actual = PerformanceConverter.convert(Event.SHOT_PUT, "12.44");
		
		assertEquals(0, Event.SHOT_PUT.compareTo(actual.getEvent()));
		assertEquals(0, new BigDecimal("12.44").compareTo(actual.getScore()));
		assertEquals("12.44", actual.getOriginalScore());
	}
	
	@Test
	public void checkSecondTypeConverting() {
		
		Performance actual = PerformanceConverter.convert(Event.HUNDRED_M, "13.43");
	
		assertEquals(Event.HUNDRED_M, actual.getEvent());
		assertEquals(0, new BigDecimal("13.43").compareTo(actual.getScore()));
		assertEquals("13.43", actual.getOriginalScore());
		
		actual = PerformanceConverter.convert(Event.THOUSAND_FIVE_HUNDRED_M, "6.51.01");
		
		assertEquals(Event.THOUSAND_FIVE_HUNDRED_M, actual.getEvent());
		assertEquals(0, new BigDecimal("411.01").compareTo(actual.getScore()));
		assertEquals("6.51.01", actual.getOriginalScore());
		
		actual = PerformanceConverter.convert(Event.HIGH_JUMP, "7.15");
		
		assertEquals(Event.HIGH_JUMP, actual.getEvent());
		assertEquals(0, new BigDecimal("715").compareTo(actual.getScore()));
		assertEquals("7.15", actual.getOriginalScore());
	}
	
	
}

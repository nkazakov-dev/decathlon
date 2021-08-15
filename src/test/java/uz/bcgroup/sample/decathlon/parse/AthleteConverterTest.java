package uz.bcgroup.sample.decathlon.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.parse.file.csv.AthleteConverter;

public class AthleteConverterTest {
	
	@BeforeEach
	public void setUp() {
	}
	
	@Test
    public void checkConverting() {
		
		String str = "Jaan Lepp;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6.22.75 ";
		
		Athlete actual = AthleteConverter.convert(str.split(";"));
		
		assertEquals("Jaan Lepp", actual.getName());
		
		assertEquals(10, actual.getPerformances().size());
		
		assertEquals("4.84", actual.findPerformanceByEvent(Event.LONG_JUMP).getOriginalScore());
	}
}

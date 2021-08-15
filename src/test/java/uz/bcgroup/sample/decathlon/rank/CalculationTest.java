package uz.bcgroup.sample.decathlon.rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.Config;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.rank.calc.Calculation;
import uz.bcgroup.sample.decathlon.rank.calc.CalculationFactory;
import uz.bcgroup.sample.decathlon.rank.calc.CalculationImpl;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class CalculationTest {

	@BeforeEach
	public void setUp() throws FileNotFoundException, IOException {
		// init test configs
		Config.initFile(FileUtil.getInputStreamFromResourceFile("/test_config.properties"));
	}
	
	@Test
	public void checkCalculation() {
		
		Calculation calculation = CalculationFactory.newCalculation();
		
		assertEquals(CalculationImpl.class, calculation.getClass());
		
		// 100m
		BigDecimal score = new BigDecimal("11.278");
		Integer actual = calculation.calcPoint(Event.HUNDRED_M, score);
		assertEquals(800, actual);
		
		//Long jump
		score = new BigDecimal("651");
		actual = calculation.calcPoint(Event.LONG_JUMP, score);
		assertEquals(700, actual);
		
		//Shot put
		score = new BigDecimal("18.40");
		actual = calculation.calcPoint(Event.SHOT_PUT, score);
		assertEquals(1000, actual);

		//High jump
		score = new BigDecimal("210");
		actual = calculation.calcPoint(Event.HIGH_JUMP, score);
		assertEquals(896, actual);

		//400 m
		score = new BigDecimal("52.58");
		actual = calculation.calcPoint(Event.FOUR_HUNDRED_M, score);
		assertEquals(700, actual);
		
		//110 m hurdles
		score = new BigDecimal("15.419");
		actual = calculation.calcPoint(Event.HUNDRED_TEN_M, score);
		assertEquals(800, actual);
		
		//Discus throw
		score = new BigDecimal("56.17");
		actual = calculation.calcPoint(Event.DISCUS_THROW, score);
		assertEquals(1000, actual);

		//Pole vault
		score = new BigDecimal("496");
		actual = calculation.calcPoint(Event.POLE_VAULT, score);
		assertEquals(898, actual);
		
		//Javelin throw
		score = new BigDecimal("64.09");
		actual = calculation.calcPoint(Event.JAVELIN_THROW, score);
		assertEquals(800, actual);

		//1500 m
		score = new BigDecimal("233.79");
		actual = calculation.calcPoint(Event.THOUSAND_FIVE_HUNDRED_M, score);
		assertEquals(1000, actual);

	}
}


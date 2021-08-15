package uz.bcgroup.sample.decathlon.rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.Config;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.rank.calc.Rate;
import uz.bcgroup.sample.decathlon.rank.calc.RateContainer;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class RateContainerTest {

	
	@BeforeEach
	public void setUp() throws FileNotFoundException, IOException {
		// init test configs
		Config.initFile(FileUtil.getInputStreamFromResourceFile("/test_config.properties"));		
	}
	
	@Test
    public void checkLoadedRate() {
		Rate actual = RateContainer.getInstance().getRateByEvent(Event.POLE_VAULT);
		
		assertEquals(0, new BigDecimal("0.2797").compareTo(actual.getRateA()));
		assertEquals(0, new BigDecimal("100").compareTo(actual.getRateB()));
		assertEquals(0, new BigDecimal("1.35").compareTo(actual.getRateC()));
	}
}

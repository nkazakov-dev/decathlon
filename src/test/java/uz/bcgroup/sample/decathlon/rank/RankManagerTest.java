package uz.bcgroup.sample.decathlon.rank;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.Config;
import uz.bcgroup.sample.decathlon.TestGenerator;
import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class RankManagerTest {
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, IOException {
		// init test configs
		Config.initFile(FileUtil.getInputStreamFromResourceFile("/test_config.properties"));		
	}
	
	@Test
	public void checkRankPopulating() {
		
		Athlete at1 = TestGenerator.getTestRandomAthlete();
		Athlete at2 = TestGenerator.getTestRandomAthlete();
		Athlete at3 = TestGenerator.getTestRandomAthlete();
		
		RankManager rankManager = new RankManager();
		rankManager.define(List.of(at1, at2, at3));
		
		assertNotNull(at1.getPosition());
		assertNotNull(at1.getPosition().getDisplay());
		assertNotNull(at1.getPosition().getPoint());
		
		assertNotNull(at2.getPosition());
		assertNotNull(at2.getPosition().getDisplay());
		assertNotNull(at2.getPosition().getPoint());
		
		assertNotNull(at3.getPosition());
		assertNotNull(at3.getPosition().getDisplay());
		assertNotNull(at3.getPosition().getPoint());
	}
}

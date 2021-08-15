package uz.bcgroup.sample.decathlon.rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.Config;
import uz.bcgroup.sample.decathlon.common.Point;
import uz.bcgroup.sample.decathlon.common.Position;
import uz.bcgroup.sample.decathlon.rank.position.PositionDefiner;
import uz.bcgroup.sample.decathlon.rank.position.PositionDefinerFactory;
import uz.bcgroup.sample.decathlon.rank.position.PositionDefinerImpl;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class PositionDefinerTest {

	@BeforeEach
	public void setUp() throws FileNotFoundException, IOException {
		// init test configs
		Config.initFile(FileUtil.getInputStreamFromResourceFile("/test_config.properties"));				
	}
	
	@Test
	public void checkPositionDefining() {
		PositionDefiner positionDefiner = PositionDefinerFactory.newPositionDefiner();
		
		assertEquals(PositionDefinerImpl.class, positionDefiner.getClass());
		
		
		Point point1 = new Point("1", 452);
		Point point2 = new Point("2", 721);
		Point point3 = new Point("3", 426);
		Point point4 = new Point("4", 721);
		Point point5 = new Point("5", 813);
		
		List<Position> actual = positionDefiner.define(List.of(point1, point2, point3, point4, point5));
		
		Function<String, Position> findBySecretId = (secretId) -> {
			return actual.stream().filter(pos -> pos.getPoint().getSecretId().equals(secretId)).findFirst().get();
		};
		
		assertEquals(5, actual.size());
		
		//rank 1
		assertEquals("1", findBySecretId.apply("5").getDisplay());
		//rank 2-3
		assertEquals("2-3", findBySecretId.apply("2").getDisplay());
		assertEquals("2-3", findBySecretId.apply("4").getDisplay());
		
		//rank 4
		assertEquals("4", findBySecretId.apply("1").getDisplay());
		
		//rank 5
		assertEquals("5", findBySecretId.apply("3").getDisplay());
	}
}

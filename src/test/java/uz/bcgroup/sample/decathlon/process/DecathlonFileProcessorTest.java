package uz.bcgroup.sample.decathlon.process;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.Config;
import uz.bcgroup.sample.decathlon.DecathlonFileProcessor;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class DecathlonFileProcessorTest {

	Path tempDir = Paths.get("./");
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, IOException {
		// init test configs
		Config.initFile(FileUtil.getInputStreamFromResourceFile("/test_config.properties"));		
	}
	
	@Test
	public void checkProcess() throws IOException, URISyntaxException {
		DecathlonFileProcessor processor = new DecathlonFileProcessor();
		processor.processDirectory(
				Paths.get(getClass().getResource("/process/input/").toURI()).toString(),
				tempDir.toString());
	}
	
	@Test
	public void checkFileProcess() throws IOException, URISyntaxException {
		Path inputFilePath = Paths.get(getClass().getResource("/process/input/results.csv").toURI());
		
		Path expectedOutputFile = Paths.get(getClass().getResource("/process/output/results.xml").toURI());
		
		DecathlonFileProcessor processor = new DecathlonFileProcessor();
			
		Path outputFilePath = processor.processFile(inputFilePath, tempDir);
		
		System.out.println("output file path: " + outputFilePath.toString());
		System.out.println("output file content: " + Files.readString(outputFilePath));
		
		System.out.println("expectedoutput file content: " + Files.readString(expectedOutputFile));
		
		assertEquals(Files.readString(expectedOutputFile), Files.readString(outputFilePath));
	}
}

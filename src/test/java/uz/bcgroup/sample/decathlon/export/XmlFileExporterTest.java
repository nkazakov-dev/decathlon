package uz.bcgroup.sample.decathlon.export;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.export.file.FileExporter;
import uz.bcgroup.sample.decathlon.export.file.FileExporterFactory;
import uz.bcgroup.sample.decathlon.export.file.xml.XmlFileExporter;

public class XmlFileExporterTest {

	Path tempDir = Paths.get("./");
	
	@BeforeEach
	public void setUp() {		
		
	}
	
	@Test
	public void checkFileExport() throws FileNotFoundException {
		Path outputFilePath = tempDir.resolve("results.xml");
		
		FileExporter actual = FileExporterFactory.newXmlFileExporter();
		
		assertEquals(XmlFileExporter.class, actual.getClass());
		
		System.out.println("outFilePath: " + outputFilePath.toAbsolutePath().toString());
		
		actual.export(List.of(RankElementCreatorTest.getTestAthleteWithPosition()),
				new FileOutputStream(outputFilePath.toFile()));
		
		File actualFile = outputFilePath.toFile();
		
		assertEquals(true, actualFile.exists());
		assertEquals(true, actualFile.length() > 0);
	}
}

package uz.bcgroup.sample.decathlon.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.parse.file.FileParser;
import uz.bcgroup.sample.decathlon.parse.file.FileParserFactory;
import uz.bcgroup.sample.decathlon.parse.file.csv.CsvFileParser;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class CsvFileParserTest {
	
	private String filePath;
	
	@BeforeEach
	public void setUp() {		
		this.filePath = "/parse/results.csv";
	}

	
	@Test
	public void checkFileParse() {
		
		FileParser actual = FileParserFactory.newCsvFileParser();
		
		assertEquals(CsvFileParser.class, actual.getClass());
		
		List<Athlete> actualAthletes = actual.parse(FileUtil.getInputStreamFromResourceFile(filePath));
	
		assertEquals(2, actualAthletes.size());
	}
}

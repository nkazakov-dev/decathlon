package uz.bcgroup.sample.decathlon.parse.file;

import uz.bcgroup.sample.decathlon.parse.file.csv.CsvFileParser;

public class FileParserFactory {

	public static FileParser newCsvFileParser() {
		return new CsvFileParser();
	}
}

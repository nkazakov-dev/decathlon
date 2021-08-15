package uz.bcgroup.sample.decathlon.parse.file.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import uz.bcgroup.sample.decathlon.Constants;
import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.parse.file.FileParser;

public class CsvFileParser implements FileParser{
	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public List<Athlete> parse(InputStream input) {
		log.info("Csv parsing source...: ");
		
		List<Athlete> result = new ArrayList<Athlete>();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))){
			String line;
			
			while((line = reader.readLine()) != null) {
				if(line.trim().isEmpty()) {
					log.warning("Line is empty");
					continue;
				}
				
				String[] cols = line.split(Constants.CSV_SEPARATOR);
				result.add(AthleteConverter.convert(cols));				
			}
			
		}catch(IOException e) {
			log.severe("Cannot parse csv file: ");
			throw new IllegalArgumentException(e);
		}finally {
			if(input != null) {
				try {
					input.close();
				} catch (IOException e) {
					log.warning(e.getMessage());
				}
			}
		}
		
		log.info("Csv parsing finished");
		
		return result;
	}

}

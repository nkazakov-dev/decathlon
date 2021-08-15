package uz.bcgroup.sample.decathlon.rank.calc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import uz.bcgroup.sample.decathlon.Config;
import uz.bcgroup.sample.decathlon.Constants;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.util.FileUtil;
import uz.bcgroup.sample.decathlon.util.NumberUtil;

//singleton
public class RateContainer {

	private static RateContainer instance;
	
	public static RateContainer getInstance() {
		if(instance == null) {
			instance = new RateContainer();
		}
		
		return instance;
	}
	
	private Logger log = Logger.getLogger(RateContainer.class.getName());
	
	private List<Rate> rates;
	
	private RateContainer() {
		super();
		
		log.info("Initializing rates...");
		initRates();
		log.info("Initializing rates finished");
	}

	private void initRates() {
		rates = new ArrayList<>();
		try {
			
			log.info("Rate file name: " + Config.getProperty(Constants.RATE_FILE_PATH_KEY));
			
			String fileContent = FileUtil.readAllFromResourceFile(Config.getProperty(Constants.RATE_FILE_PATH_KEY));
			
			List<String> lines = fileContent.lines().collect(Collectors.toList());
			
			if(lines.size() < 11) {
				throw new RuntimeException("Rate file content is not correct, content must include 11 row, size: " + lines.size());
			}
			Iterator<String> it = lines.iterator();
			
			// for first row, it is header
			it.next();
			
			int rn = 0;
			
			while(it.hasNext()) {
				rn++;
				
				String line = it.next();

				// check to validation of line
				if(line.trim().isBlank()) {
					log.warning("Line is blank: ");				
					continue;
				}
				
				String[] values = line.split(Config.getProperty(Constants.RATE_FILE_SEPARATOR_KEY));
				if(values.length != 4) {
					throw new RuntimeException("Rate file content is not correct, line: " + line);
				}
				
				switch(rn) {
					case 1:{
						rates.add(createRate(Event.HUNDRED_M, values[1], values[2], values[3]));
						break;
					}
					case 2:{
						rates.add(createRate(Event.LONG_JUMP, values[1], values[2], values[3]));
						break;
					}
					case 3:{
						rates.add(createRate(Event.SHOT_PUT, values[1], values[2], values[3]));
						break;
					}
					case 4:{
						rates.add(createRate(Event.HIGH_JUMP, values[1], values[2], values[3]));
						break;
					}
					case 5:{
						rates.add(createRate(Event.FOUR_HUNDRED_M, values[1], values[2], values[3]));
						break;
					}
					case 6:{
						rates.add(createRate(Event.HUNDRED_TEN_M, values[1], values[2], values[3]));
						break;
					}
					case 7:{
						rates.add(createRate(Event.DISCUS_THROW, values[1], values[2], values[3]));
						break;
					}
					case 8:{
						rates.add(createRate(Event.POLE_VAULT, values[1], values[2], values[3]));
						break;
					}
					case 9:{
						rates.add(createRate(Event.JAVELIN_THROW, values[1], values[2], values[3]));
						break;
					}
					case 10:{
						rates.add(createRate(Event.THOUSAND_FIVE_HUNDRED_M, values[1], values[2], values[3]));
						break;
					}
				}
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException("Cannot initialize rating", e);
		}
		
	}
	
	private Rate createRate(Event event, String rateA, String rateB, String rateC) {
		Rate r = new Rate();
		r.setEvent(event);
		r.setRateA(NumberUtil.parseBigDecimal(rateA));
		r.setRateB(NumberUtil.parseBigDecimal(rateB));
		r.setRateC(NumberUtil.parseBigDecimal(rateC));
		
		return r;
	}
	
	public Rate getRateByEvent(Event event) {
		return this.rates.stream().filter(r -> r.getEvent().equals(event)).findFirst().get();
	}
	
	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}		
	
}

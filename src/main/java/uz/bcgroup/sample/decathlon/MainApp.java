package uz.bcgroup.sample.decathlon;

import java.io.IOException;
import java.util.logging.Logger;

public class MainApp {

	public static void main(String... args) throws Exception {
		Logger log = Logger.getLogger(MainApp.class.getName());

		log.info("App started..");

		DecathlonFileProcessor processor = new DecathlonFileProcessor();
		processor.processDirectory(Config.getProperty(Constants.INPUT_DIR_KEY), 
				Config.getProperty(Constants.OUTPUT_DIR_KEY));

		log.info("Press enter to exit...");
		try {
			System.in.read();
		} catch (IOException e) {
			System.exit(1);
		}
	}
	
}

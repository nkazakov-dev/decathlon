package uz.bcgroup.sample.decathlon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Logger;

import uz.bcgroup.sample.decathlon.util.FileUtil;

public class Config {
	private static Logger log = Logger.getLogger(Config.class.getName());
	
	private static Properties appProperties;
	
	static {
		try {
			appProperties = new Properties();
			
			log.info("Loading configs... ");
			
			// load properties from application resources
			appProperties.load(new StringReader(FileUtil.readAllFromResourceFile("/" + Constants.CONFIG_FILE_NAME)));
			
			// check first than whether custom config file exists sibling to jar file
			String customConfigFileAbsolutePath = FileUtil.getJarDirAbsolutePath() + File.separator + Constants.CONFIG_FILE_NAME;
			if(FileUtil.isFileExists(customConfigFileAbsolutePath)) {
				appProperties.load(new FileInputStream(customConfigFileAbsolutePath));				
			}
			
			log.info("Loading configs finished ");
			
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException("Cannot load properties");
		}		
	}
	
	public static void initFile(InputStream inputStream) throws IOException {
		appProperties.load(inputStream);
	}
	
	public static String getProperty(String key) {
		return appProperties.getProperty(key, "").trim();
	}
}

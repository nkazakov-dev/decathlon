package uz.bcgroup.sample.decathlon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.export.file.FileExporter;
import uz.bcgroup.sample.decathlon.export.file.FileExporterFactory;
import uz.bcgroup.sample.decathlon.parse.file.FileParser;
import uz.bcgroup.sample.decathlon.parse.file.FileParserFactory;
import uz.bcgroup.sample.decathlon.rank.RankManager;
import uz.bcgroup.sample.decathlon.util.FileUtil;

public class DecathlonFileProcessor {
	private Logger log = Logger.getLogger(DecathlonFileProcessor.class.getName());
	
	
	public DecathlonFileProcessor() {
		super();
	}
	
	public void processDirectory(String inputDirectory, String outputDirectory) throws IOException {
		log.info("Checking directories... :" + inputDirectory + "," + outputDirectory);
		
		Path inputPath = Paths.get(inputDirectory);
		Path outputPath = Paths.get(outputDirectory);
		
		// check input
		FileUtil.directoryValidate(inputPath);
		
		// check output
		// if output directory empty, we must create it
		Files.createDirectories(outputPath);
		
		log.info("Checking directories finished");
		
		Iterator<Path> filePaths;
		try {
			filePaths = Files.list(inputPath).iterator();
		} catch (IOException e) {
			throw new RuntimeException("Cannot read files: " + inputDirectory, e);
		}	
		
		while(filePaths.hasNext()) {
			processFile(filePaths.next(), outputPath);
		}
	}
	
		
	public Path processFile(Path inputFilePath, Path outputPath) {
		String fileName = FileUtil.getFileName(inputFilePath);
		
		Path outputFilePath = outputPath.resolve(
				FileUtil.removeExtension(fileName) + ".xml").toAbsolutePath();
		
		log.info("Processing file... : " + inputFilePath.toAbsolutePath().toString());
		
		try {
			FileParser parser = FileParserFactory.newCsvFileParser();
			FileExporter exporter = FileExporterFactory.newXmlFileExporter();
			
			RankManager rankManager = new RankManager();
			
			List<Athlete> athletes = parser.parse(new FileInputStream(inputFilePath.toFile()));
			rankManager.define(athletes);
			exporter.export(athletes, new FileOutputStream(outputFilePath.toFile()));
			
		}catch(Exception e) {
			e.printStackTrace();
			log.severe("Process file error: " + e.getMessage());
		}			
		
		return outputFilePath;
	}
	
	
}

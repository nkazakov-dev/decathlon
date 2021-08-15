package uz.bcgroup.sample.decathlon.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import uz.bcgroup.sample.decathlon.MainApp;

public class FileUtil {

	public static void directoryValidate(Path directoryPath) {
		if(!Files.isDirectory(directoryPath) || !Files.isReadable(directoryPath)) {
			throw new RuntimeException("Directory is not accessible: " + directoryPath);
		}
	}
	
	public static String getFileName(Path path) {
		Path abs = path.toAbsolutePath();
		return abs.getName(abs.getNameCount()-1).toString();
	}
	
	public static String removeExtension(String fileName) {
		return fileName.replaceFirst("[.][^.]+$", "");
	}
	
	public static String getJarDirAbsolutePath() {
	    String absolutePath = MainApp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	    try {
			absolutePath = URLDecoder.decode(absolutePath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Cannot get jar dir", e);
		}
	    absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("/"));
	    if(absolutePath.startsWith("/")) {
	    	absolutePath = absolutePath.substring(1);
	    }
	    return absolutePath;
	}
	
	public static boolean isFileExists(String filePath) {
		return Paths.get(filePath).toFile().exists();
	}
	
	public static String readAllFromResourceFile(String filePath) throws URISyntaxException {
		StringBuilder sb = new StringBuilder();
		try {
			
			/*URL url = FileUtil.class.getResource(filePath);
			Path path = Paths.get(url.toURI());
			InputStream in = new FileInputStream(path.toAbsolutePath().toFile());*/
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(FileUtil.class.getResourceAsStream(filePath)));
			
			char[] buffer = new char[1024];
			while(reader.read(buffer) != -1) {
				sb.append(buffer);
			}
		}catch(IOException e) {
			throw new RuntimeException("Cannot read resource file: " + filePath, e);
		}
		return sb.toString();
	}
	
	public static InputStream getInputStreamFromResourceFile(String filePath) {
		return FileUtil.class.getResourceAsStream(filePath);
	}
}

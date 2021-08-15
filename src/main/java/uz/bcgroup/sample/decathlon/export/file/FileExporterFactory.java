package uz.bcgroup.sample.decathlon.export.file;

import uz.bcgroup.sample.decathlon.export.file.xml.XmlFileExporter;

public class FileExporterFactory {

	public static FileExporter newXmlFileExporter() {
		return new XmlFileExporter();
	}
}

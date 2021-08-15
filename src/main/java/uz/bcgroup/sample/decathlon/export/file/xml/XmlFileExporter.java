package uz.bcgroup.sample.decathlon.export.file.xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.AthleteSorter;
import uz.bcgroup.sample.decathlon.export.file.FileExporter;
import uz.bcgroup.sample.decathlon.util.XmlUtil;

public class XmlFileExporter implements FileExporter {
	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public void export(List<Athlete> athletes, OutputStream output) {
		log.info("Xml export started...: ");
		
		try {
			
			Document doc = XmlUtil.createXmlDocument();
			addElements(doc, athletes);
			writeToOutput(doc, output);
			
		} catch (Exception e) {
			log.severe("Cannot export xml to file: ");			
			throw new IllegalArgumentException(e);
		}finally {
			if(output != null) {
				try {
					output.close();
				} catch (IOException e) {
					log.warning(e.getMessage());
				}
			}
		}
		
		log.info("Xml export finished");		
	}
	
	private void addElements(Document doc, List<Athlete> athletes) {
		List<Athlete> sortedAthletes = AthleteSorter.sortDescendByPosition(athletes);

		// ranks root tag
		Element ranks = doc.createElement("ranks");
		
		for(Athlete athlete: sortedAthletes) {
			ranks.appendChild(RankElementCreator.create(doc, athlete));
		}
		
		doc.appendChild(ranks);
	}	
	
	
	
	private void writeToOutput(Document doc, OutputStream output) throws TransformerException, FileNotFoundException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		// pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        // set xml encoding
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
		
		DOMSource source = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(output);
		transformer.transform(source, streamResult);		
	}

}

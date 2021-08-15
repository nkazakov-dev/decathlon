package uz.bcgroup.sample.decathlon.export;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uz.bcgroup.sample.decathlon.TestGenerator;
import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.export.file.xml.AthleteElementCreator;
import uz.bcgroup.sample.decathlon.util.XmlUtil;

public class AthleteElementCreatorTest {

	
	@BeforeEach
	public void setUp() {
	}
	
	@Test
    public void checkEventCreating() throws ParserConfigurationException {
		
		Document doc = XmlUtil.createXmlDocument();
		
		Element actual = AthleteElementCreator.createEvent(doc, Event.POLE_VAULT, "32.45");
		
		assertEquals(Event.POLE_VAULT.name().toLowerCase(), actual.getTagName());
		assertEquals("32.45", actual.getTextContent());
	}
	
	@Test
	public void checkScoreCreating() throws ParserConfigurationException {
		Document doc = XmlUtil.createXmlDocument();
		
		Element actual = AthleteElementCreator.createScore(doc, TestGenerator.getTestRandomPerformances());
		
		assertEquals("score", actual.getTagName());
		
		assertEquals(10, actual.getChildNodes().getLength());
	}
	
	@Test
	public void checkAthleteCreating() throws ParserConfigurationException {
		Document doc = XmlUtil.createXmlDocument();
		
		Athlete at = TestGenerator.getTestRandomAthlete();
		
		Element actual = AthleteElementCreator.create(doc, at);
		
		assertEquals("athlete", actual.getTagName());
		assertEquals("name", actual.getFirstChild().getNodeName());
		assertEquals(at.getName(), actual.getFirstChild().getTextContent());
		assertEquals(2, actual.getChildNodes().getLength());
	}
	
	
}

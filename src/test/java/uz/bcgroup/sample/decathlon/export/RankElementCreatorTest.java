package uz.bcgroup.sample.decathlon.export;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uz.bcgroup.sample.decathlon.TestGenerator;
import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Point;
import uz.bcgroup.sample.decathlon.common.Position;
import uz.bcgroup.sample.decathlon.export.file.xml.RankElementCreator;
import uz.bcgroup.sample.decathlon.util.XmlUtil;

public class RankElementCreatorTest {

	@BeforeEach
	public void setUp() {
	}
	
	@Test
	public void checkRankCreating() throws ParserConfigurationException {
		Document doc = XmlUtil.createXmlDocument();
		
		Athlete at = getTestAthleteWithPosition();		
		
		Element actual = RankElementCreator.create(doc, at);
		
		assertEquals("rank", actual.getTagName());
		
		assertEquals("position", actual.getFirstChild().getNodeName());
		assertEquals("2-4", actual.getFirstChild().getTextContent());
		
		assertEquals("point", actual.getChildNodes().item(1).getNodeName());
		assertEquals("324", actual.getChildNodes().item(1).getTextContent());
		
		assertEquals(3, actual.getChildNodes().getLength());
	}
	
	public static Athlete getTestAthleteWithPosition() {
		Athlete at = TestGenerator.getTestRandomAthlete();
		
		Position position = new Position();
		position.setMinPosition(2);
		position.setMaxPosition(4);
		
		Point point = new Point(at.getSecretId(), 324);
		position.setPoint(point);
		
		at.setPosition(position);
		
		return at;
	}
}

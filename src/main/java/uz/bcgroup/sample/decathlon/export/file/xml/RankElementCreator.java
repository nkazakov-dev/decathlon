package uz.bcgroup.sample.decathlon.export.file.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uz.bcgroup.sample.decathlon.common.Athlete;

public class RankElementCreator {

	public static Element create(Document doc, Athlete athlete) {

		//rank tag
		Element rank = doc.createElement("rank");
		
		//position tag
		Element position = doc.createElement("position");
		position.appendChild(doc.createTextNode(athlete.getPosition().getDisplay()));
		rank.appendChild(position);
		
		//point tag
		Element point = doc.createElement("point");
		point.appendChild(doc.createTextNode(athlete.getPosition().getPoint().getValue().toString()));
		rank.appendChild(point);
		
		//athlete tag
		rank.appendChild(AthleteElementCreator.create(doc, athlete));
		
		return rank;
	}
	
}

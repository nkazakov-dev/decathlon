package uz.bcgroup.sample.decathlon.export.file.xml;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Event;
import uz.bcgroup.sample.decathlon.common.Performance;

public class AthleteElementCreator {

	public static Element create(Document doc, Athlete athlete) {

		//athlete tag
		Element athleteEl = doc.createElement("athlete");
		
		//name tag
		Element name = doc.createElement("name");
		name.appendChild(doc.createTextNode(athlete.getName()));
		athleteEl.appendChild(name);
		
		//score
		athleteEl.appendChild(createScore(doc, athlete.getPerformances()));		
		
		return athleteEl;
	}
	
	
	public static Element createScore(Document doc, List<Performance> performances) {
		
		Element score = doc.createElement("score");
		
		score.appendChild(createEvent(doc, Event.HUNDRED_M, getOriginalScoreByEvent(performances, Event.HUNDRED_M)));
		score.appendChild(createEvent(doc, Event.LONG_JUMP, getOriginalScoreByEvent(performances, Event.LONG_JUMP)));
		score.appendChild(createEvent(doc, Event.SHOT_PUT, getOriginalScoreByEvent(performances, Event.SHOT_PUT)));
		score.appendChild(createEvent(doc, Event.HIGH_JUMP, getOriginalScoreByEvent(performances, Event.HIGH_JUMP)));
		score.appendChild(createEvent(doc, Event.FOUR_HUNDRED_M, getOriginalScoreByEvent(performances, Event.FOUR_HUNDRED_M)));
		score.appendChild(createEvent(doc, Event.HUNDRED_TEN_M, getOriginalScoreByEvent(performances, Event.HUNDRED_TEN_M)));
		score.appendChild(createEvent(doc, Event.DISCUS_THROW, getOriginalScoreByEvent(performances, Event.DISCUS_THROW)));
		score.appendChild(createEvent(doc, Event.POLE_VAULT, getOriginalScoreByEvent(performances, Event.POLE_VAULT)));
		score.appendChild(createEvent(doc, Event.JAVELIN_THROW, getOriginalScoreByEvent(performances, Event.JAVELIN_THROW)));
		score.appendChild(createEvent(doc, Event.THOUSAND_FIVE_HUNDRED_M, getOriginalScoreByEvent(performances, Event.THOUSAND_FIVE_HUNDRED_M)));
		
		return score;
	}
	
	public static Element createEvent(Document doc, Event event, String originalScore) {
		Element el = doc.createElement(event.name().toLowerCase());
		el.appendChild(doc.createTextNode(originalScore));
		return el;
	}
	
	private static String getOriginalScoreByEvent(List<Performance> performances, Event event) {
		return performances.stream().filter(p -> p.getEvent().equals(event)).findFirst().get().getOriginalScore();
	}
}

package uz.bcgroup.sample.decathlon.rank;

import java.util.List;
import java.util.stream.Collectors;

import uz.bcgroup.sample.decathlon.common.Athlete;
import uz.bcgroup.sample.decathlon.common.Point;
import uz.bcgroup.sample.decathlon.common.Position;
import uz.bcgroup.sample.decathlon.rank.calc.Calculation;
import uz.bcgroup.sample.decathlon.rank.calc.CalculationFactory;
import uz.bcgroup.sample.decathlon.rank.position.PositionDefiner;
import uz.bcgroup.sample.decathlon.rank.position.PositionDefinerFactory;

public class RankManager{

	private Calculation calculation;
	private PositionDefiner positionDefiner;
	
	public RankManager() {
		super();
		this.calculation = CalculationFactory.newCalculation();
		this.positionDefiner = PositionDefinerFactory.newPositionDefiner();
	}
	

	public void define(List<Athlete> athletes) {

		List<Point> points = athletes.stream().map(at -> {
			Integer pointValue = at.getPerformances().stream()
					.map(pf -> calculation.calcPoint(pf.getEvent(), pf.getScore()))
					.reduce(0, Integer::sum);
			
			return new Point(at.getSecretId(),pointValue);
			
		}).collect(Collectors.toList());
		
		
		List<Position> positions = positionDefiner.define(points);
		
		athletes.forEach(at ->{
			at.setPosition(positions.stream().filter(pos -> pos.getPoint().getSecretId().equals(at.getSecretId())).findFirst().get());
		});
	}

}

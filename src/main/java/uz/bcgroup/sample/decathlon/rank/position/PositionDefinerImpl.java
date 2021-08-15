package uz.bcgroup.sample.decathlon.rank.position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import uz.bcgroup.sample.decathlon.common.Point;
import uz.bcgroup.sample.decathlon.common.Position;

public class PositionDefinerImpl implements PositionDefiner{
	
	
	public PositionDefinerImpl() {
		super();		
	}

	@Override
	public List<Position> define(List<Point> points) {
		List<Position> positions = new ArrayList<Position>(points.size());
		
		Comparator<Point> decendComparator = (p1, p2) -> p2.getValue().compareTo(p1.getValue());
		
		List<Point> pointSorted = points.stream().sorted(decendComparator).collect(Collectors.toUnmodifiableList());
		
		List<Integer> pointCount = pointSorted.stream().map(p -> (int)pointSorted.stream().filter(sorted -> sorted.getValue().equals(p.getValue())).count()).collect(Collectors.toUnmodifiableList());
		
		
		int currentRank = 1;
		Position prevPosition = null; 
		
		for(int i = 0; i < pointSorted.size(); i++) {
			Point currentPoint = pointSorted.get(i);
			int count = pointCount.get(i);
			
			if(prevPosition == null) {
				// current rank = 1
				currentRank = 1;
			}else if(currentPoint.getValue().equals(prevPosition.getPoint().getValue())) {
				// if point value equals previous one, current rank is not changed								
			}else {
				currentRank = prevPosition.getMaxPosition() + 1;
			}
			
			
			Position newPos = new Position();
			newPos.setPoint(currentPoint);
			newPos.setMinPosition(currentRank);
			newPos.setMaxPosition(currentRank + count - 1);
			
			positions.add(newPos);
			
			prevPosition = newPos;
		}
		
		return positions;
	}

}

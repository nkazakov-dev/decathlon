package uz.bcgroup.sample.decathlon.rank.position;

import java.util.List;

import uz.bcgroup.sample.decathlon.common.Point;
import uz.bcgroup.sample.decathlon.common.Position;

public interface PositionDefiner {

	List<Position> define(List<Point> points);
}

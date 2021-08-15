package uz.bcgroup.sample.decathlon.rank.position;

public class PositionDefinerFactory {

	public static PositionDefiner newPositionDefiner() {
		return new PositionDefinerImpl();
	}
}

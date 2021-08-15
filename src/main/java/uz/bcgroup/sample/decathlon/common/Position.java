package uz.bcgroup.sample.decathlon.common;


public class Position {
	
	private Point point;
	private Integer minPosition;
	private Integer maxPosition;
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public Integer getMinPosition() {
		return minPosition;
	}
	public void setMinPosition(Integer minPosition) {
		this.minPosition = minPosition;
	}
	public Integer getMaxPosition() {
		return maxPosition;
	}
	public void setMaxPosition(Integer maxPosition) {
		this.maxPosition = maxPosition;
	}
	
	public String getDisplay() {
		if(this.getMinPosition().equals(this.getMaxPosition())) {
			return this.getMinPosition().toString();
		}else {
			return this.getMinPosition().toString().concat("-").concat(this.getMaxPosition().toString());
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxPosition == null) ? 0 : maxPosition.hashCode());
		result = prime * result + ((minPosition == null) ? 0 : minPosition.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (maxPosition == null) {
			if (other.maxPosition != null)
				return false;
		} else if (!maxPosition.equals(other.maxPosition))
			return false;
		if (minPosition == null) {
			if (other.minPosition != null)
				return false;
		} else if (!minPosition.equals(other.minPosition))
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}
	

	
}

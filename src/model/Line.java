package model;

public class Line extends Shape {
	
	private MapCoordinate begin, end;
	
	public Line (MapCoordinate begin, MapCoordinate end){
		this.begin = begin;
		this.end = end;
	}
	
	public Line (MapCoordinate end){
		this(new MapCoordinate(0,0), end);
	}
	
	

	@Override
	double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the begin
	 */
	public MapCoordinate getBegin() {
		return begin;
	}

	/**
	 * @return the end
	 */
	public MapCoordinate getEnd() {
		return end;
	}

}

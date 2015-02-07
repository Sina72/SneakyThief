package model;

public class Line extends Shape {
	
	private Point begin, end;
	
	public Line (Point begin, Point end){
		this.begin = begin;
		this.end = end;
	}
	
	public Line (Point end){
		this(new Point(0,0), end);
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

}

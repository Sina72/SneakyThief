package model;

public class Point extends Shape {

	private double x,y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	@Override
	double getWidth() {
		return 0;
	}

	@Override
	double getHeight() {
		return 0;
	}

}

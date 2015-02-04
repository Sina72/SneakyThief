package model;

public abstract class Shape {
	//rotation of the shape
	private double orientation; //in angular degrees, counterclockwise
	
	abstract double getWidth();
	abstract double getHeight();
}

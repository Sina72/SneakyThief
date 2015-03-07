package model.mapElements.areas;

import model.geometry.Circular;
import model.geometry.Coordinate;
import model.geometry.Shape;

public class Sentry extends Area {

	private static final double DEFAULT_SIZE = 0;
	private static final Shape DEFAULT_SHAPE = new Circular(DEFAULT_SIZE);
	private static final double DEFAULT_ORIENTATION = 0;
	
	
	public Sentry(Coordinate coordinate){
		this(DEFAULT_SHAPE, coordinate, DEFAULT_ORIENTATION);
	}
	
	public Sentry(Shape shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
	}

}

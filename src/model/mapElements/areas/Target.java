package model.mapElements.areas;

import model.geometry.Circular;
import model.geometry.Coordinate;
import model.geometry.Shape;
import model.mapElements.MapPlacement;

public class Target extends Area {

	
	private static final double DEFAULT_SIZE = 1;
	private static final Shape DEFAULT_SHAPE = new Circular(DEFAULT_SIZE);


	public Target(Coordinate coordinate){
		this(DEFAULT_SHAPE, coordinate, MapPlacement.DEFAULT_ORIENTATION);
	}
	
	
	public Target(Shape shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
	}

}

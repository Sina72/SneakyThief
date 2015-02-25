package model.mapElements.areas;

import model.geometry.Coordinate;
import model.geometry.Shape;
import model.mapElements.MapPlacement;

public class Area extends MapPlacement {

	public Area(Shape shape, Coordinate coordinate, double orientation) {
		super(shape, coordinate, orientation);
	}

}

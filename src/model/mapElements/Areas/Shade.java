package model.mapElements.Areas;

import model.geometry.Coordinate;
import model.geometry.Shape;

public class Shade extends Area {

	// value between 0 and 1 representing the darkness of the shade, where 1 is
	// absolute darkness and 0 is no darkness.
	private double darkness = .5;

	public Shade(Shape shape, Coordinate coordinate, double orientation,
			double darkness) {
		super(shape, coordinate, orientation);
		this.darkness = darkness;
	}

	public double getDarkness() {
		return darkness;
	}

	public void setDarkness(double newDarkness) {
		if (newDarkness <= 1 && newDarkness >= 0)
			darkness = newDarkness;
	}

}

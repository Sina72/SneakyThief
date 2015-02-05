package model;

/**
 * Common structure for elements that can be put onto the map.
 * @author Stan
 *
 */
public class MapElement {
	//shape of the mapElement
	private double orientation;
	private Shape shape;
	
	public MapElement(Shape shape, double orientation){
		this.shape = shape;
		this.orientation = orientation;
	}

	public void setOrientation(double value) {
		this.orientation = value;
	}

	public double getOrientation() {
		return this.orientation;
	}

	
}
